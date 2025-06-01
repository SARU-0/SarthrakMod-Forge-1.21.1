package net.strifaru.sarthrakmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.SMBlocks;
import net.strifaru.sarthrakmod.util.SMTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SMBlockTagProvider extends BlockTagsProvider {
    public SMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SarthrakMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SMBlocks.SARTHERION_BLOCK.get())
                .add(SMBlocks.REMNANT_CORE.get())
                .add(SMBlocks.ARCANE_CATALYST.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(SMBlocks.SARTHERION_BLOCK.get())
                .add(SMBlocks.REMNANT_CORE.get())
                .add(SMBlocks.ARCANE_CATALYST.get());

        tag(SMTags.Blocks.NEEDS_SARTHERION_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(SMTags.Blocks.INCORRECT_FOR_SARTHERION_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(SMTags.Blocks.MINEABLE_WITH_BUSTER_SWORD)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_HOE);


    }
}
