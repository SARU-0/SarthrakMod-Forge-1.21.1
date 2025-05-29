package net.strifaru.sarthrakmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SMBlockTagProvider extends BlockTagsProvider {
    public SMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SarthrakMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SARTHERION_BLOCK.get())
                .add(ModBlocks.REMNANT_CORE.get())
                .add(ModBlocks.ARCANE_CATALYST.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SARTHERION_BLOCK.get())
                .add(ModBlocks.REMNANT_CORE.get())
                .add(ModBlocks.ARCANE_CATALYST.get());
    }
}
