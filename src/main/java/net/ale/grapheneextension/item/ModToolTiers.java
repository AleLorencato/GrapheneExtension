package net.ale.grapheneextension.item;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier GRAPHENE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 12f, 3f, 25, ModTags.Blocks.NEEDS_GRAPHENE_TOOL,
                    () -> Ingredient.of(ModItems.GRAPHENE.get())),
            new ResourceLocation(GrapheneExtension.MOD_ID, "graphene"), List.of(Tiers.NETHERITE), List.of());
}
