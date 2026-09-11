package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, GrapheneExtension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GRAPHENE_HELMET.get(),
                        ModItems.GRAPHENE_CHESTPLATE.get(),
                        ModItems.GRAPHENE_LEGGINGS.get(),
                        ModItems.GRAPHENE_BOOTS.get());

        // Forge Raw Materials
        this.tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_GRAPHENE.get());
        this.tag(ItemTags.create(new ResourceLocation("forge", "raw_materials/graphene")))
                .add(ModItems.RAW_GRAPHENE.get());

        // Forge Dusts
        this.tag(Tags.Items.DUSTS)
                .add(ModItems.GRAPHENE_DUST.get());
        this.tag(ItemTags.create(new ResourceLocation("forge", "dusts/graphene")))
                .add(ModItems.GRAPHENE_DUST.get());

        // Forge Ingots
        this.tag(Tags.Items.INGOTS)
                .add(ModItems.GRAPHENE.get());
        this.tag(ItemTags.create(new ResourceLocation("forge", "ingots/graphene")))
                .add(ModItems.GRAPHENE.get());
    }
}
