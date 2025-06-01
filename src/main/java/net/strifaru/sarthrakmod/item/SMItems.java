package net.strifaru.sarthrakmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.item.custom.SMBusterSword;
import net.strifaru.sarthrakmod.item.custom.SMBladeItem;

public class SMItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SarthrakMod.MOD_ID);

    public static final RegistryObject<Item> SARTHERION = ITEMS.register("sartherion",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BROKEN_SARTHERION = ITEMS.register("broken_sartherion",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SARTHERION_BLADE = ITEMS.register("sartherion_blade",
            () -> new SMBladeItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> SARTHERION_NUGGET = ITEMS.register("sartherion_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KINDER = ITEMS.register("kinder",
            () -> new Item(new Item.Properties().food(SMFoodProperties.KINDER)));


    public static final RegistryObject<Item> SARTHERION_SWORD = ITEMS.register("sartherion_sword",
            () -> new SwordItem(SMToolTiers.SARTHERION, new Item.Properties()
                    .attributes(SwordItem.createAttributes(SMToolTiers.SARTHERION, 3, -2.4f))));

    public static final RegistryObject<Item> SARTHERION_PICKAXE = ITEMS.register("sartherion_pickaxe",
            () -> new PickaxeItem(SMToolTiers.SARTHERION, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(SMToolTiers.SARTHERION, 1, -2.8f))));

    public static final RegistryObject<Item> SARTHERION_SHOVEL = ITEMS.register("sartherion_shovel",
            () -> new ShovelItem(SMToolTiers.SARTHERION, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(SMToolTiers.SARTHERION, 1.5f, -3.0f))));

    public static final RegistryObject<Item> SARTHERION_AXE = ITEMS.register("sartherion_axe",
            () -> new AxeItem(SMToolTiers.SARTHERION, new Item.Properties()
                    .attributes(AxeItem.createAttributes(SMToolTiers.SARTHERION, 6, -3.2f))));

    public static final RegistryObject<Item> SARTHERION_HOE = ITEMS.register("sartherion_hoe",
            () -> new HoeItem(SMToolTiers.SARTHERION, new Item.Properties()
                    .attributes(HoeItem.createAttributes(SMToolTiers.SARTHERION, 0, -3.0f))));

    public static final RegistryObject<Item> SARTHERION_BUSTER_SWORD = ITEMS.register("sartherion_buster_sword",
            () -> new SMBusterSword(SMToolTiers.SARTHERION, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(SMToolTiers.SARTHERION, 7, -3.0f))));
    

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
