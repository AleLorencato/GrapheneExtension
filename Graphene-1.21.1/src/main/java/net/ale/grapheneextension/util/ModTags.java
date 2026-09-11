package net.ale.grapheneextension.util;

import net.ale.grapheneextension.GrapheneExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_GRAPHENE_TOOL = tag("needs_graphene_tool");
        public static final TagKey<Block> INCORRECT_FOR_GRAPHENE_TOOL = tag("incorrect_for_graphene_tool");

        public static final TagKey<Block> ORES_GRAPHENE = commonTag("ores/graphene");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GrapheneExtension.MOD_ID, name));
        }

        private static TagKey<Block> commonTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> RAW_MATERIALS_GRAPHENE = commonTag("raw_materials/graphene");
        public static final TagKey<Item> DUSTS_GRAPHENE = commonTag("dusts/graphene");
        public static final TagKey<Item> INGOTS_GRAPHENE = commonTag("ingots/graphene");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GrapheneExtension.MOD_ID, name));
        }

        private static TagKey<Item> commonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
