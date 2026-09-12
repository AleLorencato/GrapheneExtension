package net.ale.grapheneextension.item;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GrapheneExtension.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FIRSTMOD_TAB = CREATIVE_MODE_TABS.register("firstmod_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GRAPHENE.get()))
                    .title(Component.translatable("creativetab.firstmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_GRAPHENE.get());
                        output.accept(ModItems.GRAPHENE_DUST.get());
                        output.accept(ModItems.GRAPHENE.get());
                        output.accept(ModBlocks.GRAPHENE_BLOCK.get());
                        output.accept(ModBlocks.GRAPHENE_ORE.get());
                        output.accept(ModBlocks.NETHER_GRAPHENE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_GRAPHENE_ORE.get());
                        output.accept(ModBlocks.END_STONE_GRAPHENE_ORE.get());
                        output.accept(ModItems.GRAPHENE_SWORD.get());
                        output.accept(ModItems.GRAPHENE_PICKAXE.get());
                        output.accept(ModItems.GRAPHENE_AXE.get());
                        output.accept(ModItems.GRAPHENE_SHOVEL.get());
                        output.accept(ModItems.GRAPHENE_HOE.get());
                        output.accept(ModItems.GRAPHENE_HELMET.get());
                        output.accept(ModItems.GRAPHENE_CHESTPLATE.get());
                        output.accept(ModItems.GRAPHENE_LEGGINGS.get());
                        output.accept(ModItems.GRAPHENE_BOOTS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
