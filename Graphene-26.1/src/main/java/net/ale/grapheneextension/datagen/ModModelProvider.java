package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.block.ModBlocks;
import net.ale.grapheneextension.item.ModArmorMaterials;
import net.ale.grapheneextension.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output, String modId) {
        super(output, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Blocks (blockstate, block model, and block item model are handled)
        blockModels.createTrivialCube(ModBlocks.GRAPHENE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.GRAPHENE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_GRAPHENE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.NETHER_GRAPHENE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.END_STONE_GRAPHENE_ORE.get());

        // Simple Items
        itemModels.generateFlatItem(ModItems.GRAPHENE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_GRAPHENE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.GRAPHENE_DUST.get(), ModelTemplates.FLAT_ITEM);

        // Handheld Tools
        itemModels.generateFlatItem(ModItems.GRAPHENE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GRAPHENE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GRAPHENE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GRAPHENE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GRAPHENE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Armor (native dynamic trimming in Minecraft 26.1)
        itemModels.generateTrimmableItem(ModItems.GRAPHENE_HELMET.get(), ModArmorMaterials.GRAPHENE_ASSET, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModels.generateTrimmableItem(ModItems.GRAPHENE_CHESTPLATE.get(), ModArmorMaterials.GRAPHENE_ASSET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModels.generateTrimmableItem(ModItems.GRAPHENE_LEGGINGS.get(), ModArmorMaterials.GRAPHENE_ASSET, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModels.generateTrimmableItem(ModItems.GRAPHENE_BOOTS.get(), ModArmorMaterials.GRAPHENE_ASSET, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
    }
}
