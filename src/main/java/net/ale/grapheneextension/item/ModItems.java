package net.ale.grapheneextension.item;

import net.ale.grapheneextension.GrapheneExtension;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GrapheneExtension.MOD_ID);

    public static final RegistryObject<Item> GRAPHENE = ITEMS.register("graphene", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_GRAPHENE = ITEMS.register("raw_graphene", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRAPHENE_DUST = ITEMS.register("graphene_dust", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRAPHENE_SWORD = ITEMS.register("graphene_sword",
            () -> new SwordItem(ModToolTiers.GRAPHENE, 4, -2, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_PICKAXE = ITEMS.register("graphene_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GRAPHENE, 2, -2, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_AXE = ITEMS.register("graphene_axe",
            () -> new AxeItem(ModToolTiers.GRAPHENE, 6, -3, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_SHOVEL = ITEMS.register("graphene_shovel",
            () -> new ShovelItem(ModToolTiers.GRAPHENE, 1, -2, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_HOE = ITEMS.register("graphene_hoe",
            () -> new HoeItem(ModToolTiers.GRAPHENE, 1, -2, new Item.Properties()));

    public static final RegistryObject<Item> GRAPHENE_HELMET = ITEMS.register("graphene_helmet",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_CHESTPLATE = ITEMS.register("graphene_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_LEGGINGS = ITEMS.register("graphene_leggings",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_BOOTS = ITEMS.register("graphene_boots",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
