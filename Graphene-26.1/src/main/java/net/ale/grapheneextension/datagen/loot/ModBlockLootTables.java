package net.ale.grapheneextension.datagen.loot;

import net.ale.grapheneextension.block.ModBlocks;
import net.ale.grapheneextension.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GRAPHENE_BLOCK.get());

        this.add(ModBlocks.GRAPHENE_ORE.get(),
                block -> createOreDrop(ModBlocks.GRAPHENE_ORE.get(), ModItems.RAW_GRAPHENE.get()));
        this.add(ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(), ModItems.RAW_GRAPHENE.get()));
        this.add(ModBlocks.NETHER_GRAPHENE_ORE.get(),
                block -> createNetherDrop(ModBlocks.NETHER_GRAPHENE_ORE.get(),
                        ModItems.RAW_GRAPHENE.get()));
        this.add(ModBlocks.END_STONE_GRAPHENE_ORE.get(),
                block -> createEndDrop(ModBlocks.END_STONE_GRAPHENE_ORE.get(),
                        ModItems.RAW_GRAPHENE.get()));
    }

    protected LootTable.Builder createNetherDrop(Block pBlock, Item item) {
        Holder<Enchantment> fortune = this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(
                pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(1.0F, 3.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(fortune))));
    }

    protected LootTable.Builder createEndDrop(Block pBlock, Item item) {
        Holder<Enchantment> fortune = this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(
                pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(3.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(fortune))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.get()).toList();
    }
}
