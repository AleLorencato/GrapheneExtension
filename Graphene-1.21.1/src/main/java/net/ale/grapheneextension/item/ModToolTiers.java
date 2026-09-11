package net.ale.grapheneextension.item;

import net.ale.grapheneextension.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier GRAPHENE = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_GRAPHENE_TOOL,
            2500,
            12.0f,
            3.0f,
            25,
            () -> Ingredient.of(ModItems.GRAPHENE.get())
    );
}
