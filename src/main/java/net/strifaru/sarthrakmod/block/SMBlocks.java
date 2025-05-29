package net.strifaru.sarthrakmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.custom.FusionBlock;
import net.strifaru.sarthrakmod.item.SMItems;

import java.util.function.Supplier;

public class SMBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SarthrakMod.MOD_ID);

    public static final RegistryObject<Block> REMNANT_CORE = registerBlock("remnant_core",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(33.0F, 1250.0F).sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> SARTHERION_BLOCK = registerBlock("sartherion_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(53.0F, 1250.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> ARCANE_CATALYST = registerBlock("arcane_catalyst",
            () -> new FusionBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        SMItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
