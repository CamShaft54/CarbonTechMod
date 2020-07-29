package com.camshaft54.carbontech.items;

import com.camshaft54.carbontech.CarbonTech;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(CarbonTech.TAB));
    }
}
