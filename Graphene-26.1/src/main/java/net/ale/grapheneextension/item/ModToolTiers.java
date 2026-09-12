package net.ale.grapheneextension.item;

import net.ale.grapheneextension.util.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolTiers {
    public static final ToolMaterial GRAPHENE = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_GRAPHENE_TOOL,
            2500,
            12.0F,
            3.0F,
            25,
            ModTags.Items.REPAIRS_GRAPHENE_ARMOR
    );
}
