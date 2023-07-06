package net.nayza.pixilitemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayza.pixilitemod.PixiliteMod;

public class ModItems {
    //DeferredRegister is to tell to forge that all of our items are from our mod
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PixiliteMod.MOD_ID);

    //Method to register my first item
    public static final RegistryObject<Item> PIXILITE_CRYSTAL = ITEMS.register("pixilite_crystal",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> PIXILITE_INGOT = ITEMS.register("pixilite_ingot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
