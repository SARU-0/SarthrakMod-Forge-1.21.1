package net.strifaru.sarthrakmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.strifaru.sarthrakmod.util.SMTags;

public class SMToolTiers {
    public static final Tier SARTHERION = new ForgeTier(2100,11.0F,5.0F,22,
            SMTags.Blocks.NEEDS_SARTHERION_TOOL, () -> Ingredient.of(SMItems.SARTHERION.get()),
            SMTags.Blocks.INCORRECT_FOR_SARTHERION_TOOL);
}
