package com.camshaft54.carbontech.util;


import com.camshaft54.carbontech.CarbonTech;
import com.camshaft54.carbontech.blocks.BlockItemBase;
import com.camshaft54.carbontech.blocks.CarbonOre;
import com.camshaft54.carbontech.blocks.GarnetBlock;
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
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", ItemBase::new);
    public static final RegistryObject<Item> CARBON = ITEMS.register("carbon", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> GARNET_BLOCK = BLOCKS.register("garnet_block", GarnetBlock::new);
    public static final RegistryObject<Block> CARBON_ORE = BLOCKS.register("carbon_ore", CarbonOre::new);

    // Block Items
    public static final RegistryObject<Item> GARNET_BLOCK_ITEM = ITEMS.register("garnet_block", () -> new BlockItemBase(GARNET_BLOCK.get()));
    public static final RegistryObject<Item> CARBON_ORE_ITEM = ITEMS.register("carbon_ore", () -> new BlockItemBase(CARBON_ORE.get()));

    // Tools
    public static final RegistryObject<SwordItem> GARNET_SWORD = ITEMS.register("garnet_sword", () ->
            new SwordItem(ModItemTier.GARNET, 2, -2.4F, new Item.Properties().group(CarbonTech.TAB)));
}
