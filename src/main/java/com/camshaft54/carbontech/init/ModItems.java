package com.camshaft54.carbontech.init;

import com.camshaft54.carbontech.CarbonTech;
import com.camshaft54.carbontech.blocks.BlockItemBase;
import com.camshaft54.carbontech.util.enums.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CarbonTech.MOD_ID);

    // Items
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", () -> new Item(new Item.Properties().group(CarbonTech.TAB)));
    public static final RegistryObject<Item> CARBON = ITEMS.register("carbon", () -> new Item(new Item.Properties().group(CarbonTech.TAB)));

    // Block Items
    public static final RegistryObject<Item> GARNET_BLOCK_ITEM = ITEMS.register("garnet_block",
            () -> new BlockItemBase(ModBlocks.GARNET_BLOCK.get()));
    public static final RegistryObject<Item> CARBON_ORE_ITEM = ITEMS.register("carbon_ore",
            () -> new BlockItemBase(ModBlocks.CARBON_ORE.get()));
    public static final RegistryObject<Item> CRUSHER_ITEM = ITEMS.register("crusher",
            () -> new BlockItemBase(ModBlocks.CRUSHER.get()));

    // Tools
    public static final RegistryObject<SwordItem> GARNET_SWORD = ITEMS.register("garnet_sword",
            () -> new SwordItem(ModItemTier.GARNET, 2, -2.4F, new Item.Properties().group(CarbonTech.TAB)));
}