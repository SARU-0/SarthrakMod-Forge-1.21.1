package net.strifaru.sarthrakmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.block.SMBlocks;

import java.util.Set;

public class SMLootTableProvider extends BlockLootSubProvider {
    protected SMLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        //The broken block will loot itself
        dropSelf(SMBlocks.SARTHERION_BLOCK.get());
        dropSelf(SMBlocks.ARCANE_CATALYST.get());
        dropSelf(SMBlocks.REMNANT_CORE.get());

        //The broken block will loot an item.
        /* Example with RemnantCore, but it doesn't actually loot an item, it will through a recipe.
        this.add(ModBlocks.REMNANT_CORE.get(),
                block -> createOreDrop(ModBlocks.REMNANT_CORE.get(), ModItems.BROKEN_SARTHERION.get())); */
    }

    //Method for ores blocks drop rate. Instead of createOreDrop() put createMultipleOreDrops().
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SMBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
