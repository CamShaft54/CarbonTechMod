package com.camshaft54.carbontech.util.enums;

import com.camshaft54.carbontech.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    GARNET(3, 1972, 9.0f, 3.0F, 12, () -> {
        return Ingredient.fromItems(ModItems.GARNET.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantablility;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantablility, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantablility = enchantablility;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantablility;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
