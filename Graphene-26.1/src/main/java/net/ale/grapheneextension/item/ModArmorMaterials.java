package net.ale.grapheneextension.item;

import com.google.common.collect.Maps;
import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.util.ModTags;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class ModArmorMaterials {
    public static final ResourceKey<EquipmentAsset> GRAPHENE_ASSET =
            ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(GrapheneExtension.MOD_ID, "graphene"));

    public static final ArmorMaterial GRAPHENE = new ArmorMaterial(
            31,
            makeDefense(4, 7, 9, 5, 9),
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0F,
            0.05F,
            ModTags.Items.REPAIRS_GRAPHENE_ARMOR,
            GRAPHENE_ASSET
    );

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(
                Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
        );
    }
}
