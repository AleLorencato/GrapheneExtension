package net.ale.grapheneextension.item;

import net.ale.grapheneextension.GrapheneExtension;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GrapheneExtension.MOD_ID);

    public static final DeferredItem<Item> GRAPHENE = ITEMS.registerSimpleItem("graphene");
    public static final DeferredItem<Item> RAW_GRAPHENE = ITEMS.registerSimpleItem("raw_graphene");
    public static final DeferredItem<Item> GRAPHENE_DUST = ITEMS.registerSimpleItem("graphene_dust");

    // Ferramentas
    public static final DeferredItem<Item> GRAPHENE_SWORD = ITEMS.registerItem("graphene_sword",
            Item::new, p -> p.sword(ModToolTiers.GRAPHENE, 4.0F, -2.0F));

    public static final DeferredItem<Item> GRAPHENE_PICKAXE = ITEMS.registerItem("graphene_pickaxe",
            Item::new, p -> p.pickaxe(ModToolTiers.GRAPHENE, 2.0F, -2.0F));

    public static final DeferredItem<AxeItem> GRAPHENE_AXE = ITEMS.registerItem("graphene_axe",
            p -> new AxeItem(ModToolTiers.GRAPHENE, 6.0F, -3.0F, p));

    public static final DeferredItem<ShovelItem> GRAPHENE_SHOVEL = ITEMS.registerItem("graphene_shovel",
            p -> new ShovelItem(ModToolTiers.GRAPHENE, 1.0F, -2.0F, p));

    public static final DeferredItem<HoeItem> GRAPHENE_HOE = ITEMS.registerItem("graphene_hoe",
            p -> new HoeItem(ModToolTiers.GRAPHENE, 1.0F, -2.0F, p));

    // Armaduras
    public static final DeferredItem<Item> GRAPHENE_HELMET = ITEMS.registerItem("graphene_helmet",
            Item::new, p -> p.humanoidArmor(ModArmorMaterials.GRAPHENE, ArmorType.HELMET));

    public static final DeferredItem<Item> GRAPHENE_CHESTPLATE = ITEMS.registerItem("graphene_chestplate",
            Item::new, p -> p.humanoidArmor(ModArmorMaterials.GRAPHENE, ArmorType.CHESTPLATE));

    public static final DeferredItem<Item> GRAPHENE_LEGGINGS = ITEMS.registerItem("graphene_leggings",
            Item::new, p -> p.humanoidArmor(ModArmorMaterials.GRAPHENE, ArmorType.LEGGINGS));

    public static final DeferredItem<Item> GRAPHENE_BOOTS = ITEMS.registerItem("graphene_boots",
            Item::new, p -> p.humanoidArmor(ModArmorMaterials.GRAPHENE, ArmorType.BOOTS));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
