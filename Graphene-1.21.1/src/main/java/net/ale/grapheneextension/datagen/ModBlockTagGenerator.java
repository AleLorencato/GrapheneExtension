package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.block.ModBlocks;
import net.ale.grapheneextension.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GrapheneExtension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GRAPHENE_BLOCK.get(),
                        ModBlocks.GRAPHENE_ORE.get(),
                        ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
                        ModBlocks.NETHER_GRAPHENE_ORE.get(),
                        ModBlocks.END_STONE_GRAPHENE_ORE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GRAPHENE_ORE.get(),
                        ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
                        ModBlocks.NETHER_GRAPHENE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_GRAPHENE_ORE.get());

        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.GRAPHENE_ORE.get(),
                        ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
                        ModBlocks.NETHER_GRAPHENE_ORE.get(),
                        ModBlocks.END_STONE_GRAPHENE_ORE.get());

        this.tag(ModTags.Blocks.ORES_GRAPHENE)
                .add(ModBlocks.GRAPHENE_ORE.get(),
                        ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
                        ModBlocks.NETHER_GRAPHENE_ORE.get(),
                        ModBlocks.END_STONE_GRAPHENE_ORE.get());
    }
}
