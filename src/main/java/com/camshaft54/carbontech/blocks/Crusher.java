package com.camshaft54.carbontech.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;


@SuppressWarnings({"NullableProblems", "deprecation"})
public class Crusher extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16), Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(13, 2, 1, 15, 15, 3), Block.makeCuboidShape(13, 2, 13, 15, 15, 15),
            Block.makeCuboidShape(1, 2, 13, 3, 15, 15), Block.makeCuboidShape(1, 2, 1, 3, 15, 3),
            Block.makeCuboidShape(1, 1, 1, 15, 2, 15)).reduce((v1, v2) ->
            VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16), Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(13, 2, 13, 15, 15, 15), Block.makeCuboidShape(1, 2, 13, 3, 15, 15),
            Block.makeCuboidShape(1, 2, 1, 3, 15, 3), Block.makeCuboidShape(13, 2, 1, 15, 15, 3),
            Block.makeCuboidShape(1, 1, 1, 15, 2, 15)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16), Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(13, 2, 13, 15, 15, 15), Block.makeCuboidShape(1, 2, 13, 3, 15, 15),
            Block.makeCuboidShape(1, 2, 1, 3, 15, 3), Block.makeCuboidShape(13, 2, 1, 15, 15, 3),
            Block.makeCuboidShape(1, 1, 1, 15, 2, 15)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16), Block.makeCuboidShape(1, 15, 1, 15, 16, 15),
            Block.makeCuboidShape(1, 2, 13, 3, 15, 15), Block.makeCuboidShape(1, 2, 1, 3, 15, 3),
            Block.makeCuboidShape(13, 2, 1, 15, 15, 3), Block.makeCuboidShape(13, 2, 13, 15, 15, 15),
            Block.makeCuboidShape(1, 1, 1, 15, 2, 15)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public Crusher() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}
