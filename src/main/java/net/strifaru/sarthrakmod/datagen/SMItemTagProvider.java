package net.strifaru.sarthrakmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.item.SMItems;
import net.strifaru.sarthrakmod.util.SMTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SMItemTagProvider extends ItemTagsProvider {
    public SMItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, SarthrakMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(SMTags.Items.TRANSFORMABLE_ITEMS)
                .add(SMItems.SARTHERION.get())
                .add(SMItems.SARTHERION_NUGGET.get())
                .add(SMItems.BROKEN_SARTHERION.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(SMItems.SARTHERION_HELMET.get())
                .add(SMItems.SARTHERION_CHESTPLATE.get())
                .add(SMItems.SARTHERION_LEGGINGS.get())
                .add(SMItems.SARTHERION_BOOTS.get());

    }

}