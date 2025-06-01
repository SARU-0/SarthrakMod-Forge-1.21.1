package net.strifaru.sarthrakmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.strifaru.sarthrakmod.SarthrakMod;

public class SMTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_SARTHERION_TOOL = createTag("needs_sartherion_tool");
        public static final TagKey<Block> INCORRECT_FOR_SARTHERION_TOOL = createTag("incorrect_for_sartherion_tool");
        public static final TagKey<Block> MINEABLE_WITH_BUSTER_SWORD = createTag("mineable_with_buster_sword");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(SarthrakMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SarthrakMod.MOD_ID, name));
        }
    }
}
