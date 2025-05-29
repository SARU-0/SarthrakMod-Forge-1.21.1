package net.strifaru.sarthrakmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.SMBlocks;

public class SMCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SarthrakMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SARTHRAK_ITEMS_TAB = CREATIVE_MODE_TABS.register("sarthrak_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SMItems.SARTHERION.get()))
                    .title(Component.translatable("creativetab.sarthrakmod.sarthrak_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(SMItems.SARTHERION.get());
                        output.accept(SMItems.BROKEN_SARTHERION.get());
                        output.accept(SMItems.SARTHERION_BLADE.get());
                        output.accept(SMItems.SARTHERION_NUGGET.get());

                    }).build());


    public static final RegistryObject<CreativeModeTab> SARTHRAK_BLOCKS_TAB = CREATIVE_MODE_TABS.register("sarthrak_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SMBlocks.SARTHERION_BLOCK.get()))
                    .withTabsBefore(SARTHRAK_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.sarthrakmod.sarthrak_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(SMBlocks.SARTHERION_BLOCK.get());
                        output.accept(SMBlocks.REMNANT_CORE.get());
                        output.accept(SMBlocks.ARCANE_CATALYST.get());

                    }).build());


    public static final RegistryObject<CreativeModeTab> SARTHRAK_FOODS_TAB = CREATIVE_MODE_TABS.register("sarthrak_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SMItems.KINDER.get()))
                    .title(Component.translatable("creativetab.sarthrakmod.sarthrak_foods"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(SMItems.KINDER.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
