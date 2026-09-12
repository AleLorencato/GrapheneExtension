package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.item.ModItems;
import net.ale.grapheneextension.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, GrapheneExtension.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GRAPHENE_HELMET.get(),
                        ModItems.GRAPHENE_CHESTPLATE.get(),
                        ModItems.GRAPHENE_LEGGINGS.get(),
                        ModItems.GRAPHENE_BOOTS.get());

        this.tag(ModTags.Items.REPAIRS_GRAPHENE_ARMOR)
                .add(ModItems.GRAPHENE.get());

        // Raw materials (c: and forge: aliases)
        this.tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_GRAPHENE.get());
        this.tag(ModTags.Items.RAW_MATERIALS_GRAPHENE)
                .add(ModItems.RAW_GRAPHENE.get());
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("forge", "raw_materials/graphene")))
                .add(ModItems.RAW_GRAPHENE.get());

        // Dusts (c: and forge: aliases)
        this.tag(Tags.Items.DUSTS)
                .add(ModItems.GRAPHENE_DUST.get());
        this.tag(ModTags.Items.DUSTS_GRAPHENE)
                .add(ModItems.GRAPHENE_DUST.get());
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("forge", "dusts/graphene")))
                .add(ModItems.GRAPHENE_DUST.get());

        // Ingots (c: and forge: aliases)
        this.tag(Tags.Items.INGOTS)
                .add(ModItems.GRAPHENE.get());
        this.tag(ModTags.Items.INGOTS_GRAPHENE)
                .add(ModItems.GRAPHENE.get());
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("forge", "ingots/graphene")))
                .add(ModItems.GRAPHENE.get());
    }
}
