package net.strifaru.sarthrakmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.SarthrakMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SarthrakMod.MOD_ID);

    public static final RegistryObject<Item> SARTHERION = ITEMS.register("sartherion",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BROKEN_SARTHERION = ITEMS.register("broken_sartherion",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
