package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.block.ModBlocks;
import net.ale.grapheneextension.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    private static final List<ItemLike> GRAPHENE_SMELTABLES = List.of(
            ModItems.RAW_GRAPHENE.get(),
            ModBlocks.GRAPHENE_ORE.get(),
            ModBlocks.NETHER_GRAPHENE_ORE.get(),
            ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
            ModBlocks.END_STONE_GRAPHENE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
        oreBlasting(pWriter, GRAPHENE_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPHENE_DUST.get(), 0.5f, 100,
                "graphene_dust");
        oreSmelting(pWriter, GRAPHENE_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPHENE_DUST.get(), 0.4f, 200,
                "graphene_dust");

        // 8 Pós de Grafeno em moldura -> 1 Grafeno
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GRAPHENE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ModItems.GRAPHENE_DUST.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE_DUST.get()), has(ModItems.GRAPHENE_DUST.get()))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(GrapheneExtension.MOD_ID,
                        "graphene_from_graphene_dust"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAPHENE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRAPHENE.get(), 9)
                .requires(ModBlocks.GRAPHENE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GRAPHENE_BLOCK.get()),
                        has(ModBlocks.GRAPHENE_BLOCK.get()))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(GrapheneExtension.MOD_ID,
                        "graphene_from_graphene_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" X ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_AXE.get())
                .pattern(" SS")
                .pattern(" XS")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" X ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_HOE.get())
                .pattern(" SS")
                .pattern(" X ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);
    }
}
