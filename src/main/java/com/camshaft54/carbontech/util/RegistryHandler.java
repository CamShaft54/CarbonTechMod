package com.camshaft54.carbontech.util;


import com.camshaft54.carbontech.CarbonTech;
import com.camshaft54.carbontech.blocks.BlockItemBase;
import com.camshaft54.carbontech.blocks.RubyBlock;
import com.camshaft54.carbontech.items.ItemBase;
import com.camshaft54.carbontech.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CarbonTech.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CarbonTech.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> CARBON = ITEMS.register("carbon", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));

    // Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4F, new Item.Properties().group(CarbonTech.TAB)));
}
