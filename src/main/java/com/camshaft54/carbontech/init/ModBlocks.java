package com.camshaft54.carbontech.init;

import com.camshaft54.carbontech.CarbonTech;
import com.camshaft54.carbontech.blocks.CarbonOre;
import com.camshaft54.carbontech.blocks.Crusher;
import com.camshaft54.carbontech.blocks.GarnetBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CarbonTech.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Blocks
    public static final RegistryObject<Block> GARNET_BLOCK = BLOCKS.register("garnet_block", GarnetBlock::new);
    public static final RegistryObject<Block> CARBON_ORE = BLOCKS.register("carbon_ore", CarbonOre::new);
    public static final RegistryObject<Block> CRUSHER = BLOCKS.register("crusher", Crusher::new);
}
