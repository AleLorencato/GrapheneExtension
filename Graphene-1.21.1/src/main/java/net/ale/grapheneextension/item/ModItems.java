package net.ale.grapheneextension.item;

import net.ale.grapheneextension.GrapheneExtension;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GrapheneExtension.MOD_ID);

    public static final DeferredItem<Item> GRAPHENE = ITEMS.registerSimpleItem("graphene", new Item.Properties());
    public static final DeferredItem<Item> RAW_GRAPHENE = ITEMS.registerSimpleItem("raw_graphene", new Item.Properties());
    public static final DeferredItem<Item> GRAPHENE_DUST = ITEMS.registerSimpleItem("graphene_dust", new Item.Properties());

    // Ferramentas
    public static final DeferredItem<SwordItem> GRAPHENE_SWORD = ITEMS.register("graphene_sword",
            () -> new SwordItem(ModToolTiers.GRAPHENE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.GRAPHENE, 4, -2.0F))));

    public static final DeferredItem<PickaxeItem> GRAPHENE_PICKAXE = ITEMS.register("graphene_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GRAPHENE,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.GRAPHENE, 2, -2.0F))));

    public static final DeferredItem<AxeItem> GRAPHENE_AXE = ITEMS.register("graphene_axe",
            () -> new AxeItem(ModToolTiers.GRAPHENE,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.GRAPHENE, 6, -3.0F))));

    public static final DeferredItem<ShovelItem> GRAPHENE_SHOVEL = ITEMS.register("graphene_shovel",
            () -> new ShovelItem(ModToolTiers.GRAPHENE,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.GRAPHENE, 1, -2.0F))));

    public static final DeferredItem<HoeItem> GRAPHENE_HOE = ITEMS.register("graphene_hoe",
            () -> new HoeItem(ModToolTiers.GRAPHENE,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.GRAPHENE, 1, -2.0F))));

    // Armaduras
    public static final DeferredItem<ArmorItem> GRAPHENE_HELMET = ITEMS.register("graphene_helmet",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(31))));

    public static final DeferredItem<ArmorItem> GRAPHENE_CHESTPLATE = ITEMS.register("graphene_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(31))));

    public static final DeferredItem<ArmorItem> GRAPHENE_LEGGINGS = ITEMS.register("graphene_leggings",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(31))));

    public static final DeferredItem<ArmorItem> GRAPHENE_BOOTS = ITEMS.register("graphene_boots",
            () -> new ArmorItem(ModArmorMaterials.GRAPHENE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(31))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
