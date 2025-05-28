package net.strifaru.sarthrakmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.item.custom.BladeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SarthrakMod.MOD_ID);

    public static final RegistryObject<Item> SARTHERION = ITEMS.register("sartherion",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BROKEN_SARTHERION = ITEMS.register("broken_sartherion",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SARTHERION_BLADE = ITEMS.register("sartherion_blade",
            () -> new BladeItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> SARTHERION_NUGGET = ITEMS.register("sartherion_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KINDER = ITEMS.register("kinder",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KINDER)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
