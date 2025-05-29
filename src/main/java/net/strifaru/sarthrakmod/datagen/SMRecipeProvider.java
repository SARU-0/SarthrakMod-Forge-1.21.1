package net.strifaru.sarthrakmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.ModBlocks;
import net.strifaru.sarthrakmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SMRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SMRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> SARTHRAK_SMELTABLES = List.of(ModBlocks.REMNANT_CORE.get()); //Add to the list any other smeltable item.

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SARTHERION_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SARTHERION.get())
                .unlockedBy(getHasName(ModItems.SARTHERION.get()), has(ModItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ARCANE_CATALYST.get())
                .pattern("SSS")
                .pattern("SLS")
                .pattern("CCC")
                .define('S', ModItems.SARTHERION.get())
                .define('L', Items.LAVA_BUCKET)
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(ModItems.SARTHERION.get()), has(ModItems.SARTHERION.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SARTHERION.get())
                .pattern(" G ")
                .pattern("BDB")
                .pattern(" B ")
                .define('B', ModItems.BROKEN_SARTHERION.get())
                .define('D', Items.DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(ModItems.BROKEN_SARTHERION.get()), has(ModItems.BROKEN_SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SARTHERION_BLADE.get())
                .pattern("  S")
                .pattern(" D ")
                .pattern("B  ")
                .define('S', ModItems.SARTHERION.get())
                .define('D', Items.DIAMOND)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.SARTHERION.get()), has(ModItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KINDER.get())
                .pattern(" L ")
                .pattern("CPC")
                .pattern(" C ")
                .define('P', ModItems.SARTHERION_NUGGET.get())
                .define('L', Items.MILK_BUCKET)
                .define('C', Items.COCOA_BEANS)
                .unlockedBy(getHasName(ModItems.SARTHERION.get()), has(ModItems.SARTHERION.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SARTHERION_NUGGET.get(), 9)
                .requires(ModItems.SARTHERION.get())
                .unlockedBy(getHasName(ModItems.SARTHERION.get()), has(ModItems.SARTHERION.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SARTHERION.get(), 9)
                .requires(ModBlocks.SARTHERION_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SARTHERION_BLOCK.get()), has(ModBlocks.SARTHERION_BLOCK.get())).save(pRecipeOutput, SarthrakMod.MOD_ID + ":sartherion_from_sartherion_block");


        oreSmelting(pRecipeOutput, SARTHRAK_SMELTABLES, RecipeCategory.MISC, ModItems.BROKEN_SARTHERION.get(), 0.25f, 200, "broken_sartherion_smelting");
        oreBlasting(pRecipeOutput, SARTHRAK_SMELTABLES, RecipeCategory.MISC, ModItems.BROKEN_SARTHERION.get(), 0.25f, 100, "broken_sartherion_blasting");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, SarthrakMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
