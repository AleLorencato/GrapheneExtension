package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.GrapheneExtension;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = GrapheneExtension.MOD_ID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(output -> new ModModelProvider(output, GrapheneExtension.MOD_ID));
        event.createProvider(ModEquipmentAssetProvider::new);
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        event.createDatapackRegistryObjects(ModWorldGenProvider.BUILDER);
        event.createProvider(ModLootTableProvider::create);
        event.createProvider(ModRecipeProvider.Runner::new);
        event.createProvider(ModBlockTagGenerator::new);
        event.createProvider(ModItemTagGenerator::new);
    }
}
