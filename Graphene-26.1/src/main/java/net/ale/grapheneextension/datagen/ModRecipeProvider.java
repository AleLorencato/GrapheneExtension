package net.ale.grapheneextension.datagen;

import net.ale.grapheneextension.block.ModBlocks;
import net.ale.grapheneextension.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
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

    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        oreBlasting(GRAPHENE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.GRAPHENE_DUST.get(), 0.5f, 100, "graphene_dust");
        oreSmelting(GRAPHENE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.GRAPHENE_DUST.get(), 0.4f, 200, "graphene_dust");

        // 8 Graphene dusts around -> 1 Graphene
        this.shaped(RecipeCategory.MISC, ModItems.GRAPHENE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ModItems.GRAPHENE_DUST.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE_DUST.get()), this.has(ModItems.GRAPHENE_DUST.get()))
                .save(this.output, "grapheneextension:graphene_from_graphene_dust");

        this.shaped(RecipeCategory.MISC, ModBlocks.GRAPHENE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.GRAPHENE.get(), 9)
                .requires(ModBlocks.GRAPHENE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GRAPHENE_BLOCK.get()), this.has(ModBlocks.GRAPHENE_BLOCK.get()))
                .save(this.output, "grapheneextension:graphene_from_graphene_block");

        this.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_PICKAXE.get())
                .pattern("SSS")
                .pattern(" X ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_AXE.get())
                .pattern(" SS")
                .pattern(" XS")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_SHOVEL.get())
                .pattern(" S ")
                .pattern(" X ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.TOOLS, ModItems.GRAPHENE_HOE.get())
                .pattern(" SS")
                .pattern(" X ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" X ")
                .define('S', ModItems.GRAPHENE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);

        this.shaped(RecipeCategory.COMBAT, ModItems.GRAPHENE_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), this.has(ModItems.GRAPHENE.get()))
                .save(this.output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Graphene Recipes";
        }
    }
}
