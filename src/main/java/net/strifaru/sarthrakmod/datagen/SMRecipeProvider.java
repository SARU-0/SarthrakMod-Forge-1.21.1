package net.strifaru.sarthrakmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.SMBlocks;
import net.strifaru.sarthrakmod.item.SMItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SMRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SMRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> SARTHRAK_SMELTABLES = List.of(SMBlocks.REMNANT_CORE.get()); //Add to the list any other smeltable item.

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMBlocks.SARTHERION_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', SMItems.SARTHERION.get())
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMBlocks.ARCANE_CATALYST.get())
                .pattern("SSS")
                .pattern("SLS")
                .pattern("CCC")
                .define('S', SMItems.SARTHERION.get())
                .define('L', Items.LAVA_BUCKET)
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION.get())
                .pattern(" G ")
                .pattern("BDB")
                .pattern(" B ")
                .define('B', SMItems.BROKEN_SARTHERION.get())
                .define('D', Items.DIAMOND)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(SMItems.BROKEN_SARTHERION.get()), has(SMItems.BROKEN_SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION_BLADE.get())
                .pattern("  S")
                .pattern(" D ")
                .pattern("B  ")
                .define('S', SMItems.SARTHERION.get())
                .define('D', Items.DIAMOND)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.KINDER.get())
                .pattern(" L ")
                .pattern("CPC")
                .pattern(" C ")
                .define('P', SMItems.SARTHERION_NUGGET.get())
                .define('L', Items.MILK_BUCKET)
                .define('C', Items.COCOA_BEANS)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" B ")
                .define('S', SMItems.SARTHERION.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION_PICKAXE.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern(" B ")
                .define('S', SMItems.SARTHERION.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION_AXE.get())
                .pattern(" SS")
                .pattern(" BS")
                .pattern(" B ")
                .define('S', SMItems.SARTHERION.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION_SHOVEL.get())
                .pattern(" S ")
                .pattern(" B ")
                .pattern(" B ")
                .define('S', SMItems.SARTHERION.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SMItems.SARTHERION_HOE.get())
                .pattern("SS ")
                .pattern(" B ")
                .pattern(" B ")
                .define('S', SMItems.SARTHERION.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SMItems.SARTHERION_NUGGET.get(), 9)
                .requires(SMItems.SARTHERION.get())
                .unlockedBy(getHasName(SMItems.SARTHERION.get()), has(SMItems.SARTHERION.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SMItems.SARTHERION.get(), 9)
                .requires(SMBlocks.SARTHERION_BLOCK.get())
                .unlockedBy(getHasName(SMBlocks.SARTHERION_BLOCK.get()), has(SMBlocks.SARTHERION_BLOCK.get())).save(pRecipeOutput, SarthrakMod.MOD_ID + ":sartherion_from_sartherion_block");


        oreSmelting(pRecipeOutput, SARTHRAK_SMELTABLES, RecipeCategory.MISC, SMItems.BROKEN_SARTHERION.get(), 0.25f, 200, "broken_sartherion_smelting");
        oreBlasting(pRecipeOutput, SARTHRAK_SMELTABLES, RecipeCategory.MISC, SMItems.BROKEN_SARTHERION.get(), 0.25f, 100, "broken_sartherion_blasting");

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
