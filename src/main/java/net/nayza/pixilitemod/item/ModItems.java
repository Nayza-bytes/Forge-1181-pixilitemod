package net.nayza.pixilitemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayza.pixilitemod.PixiliteMod;
import net.nayza.pixilitemod.item.custom.PixiliteChestFinderItem;
import net.nayza.pixilitemod.item.custom.SulimSeedsItem;

public class ModItems {
    //DeferredRegister is to tell to forge that all of our items are from our mod
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PixiliteMod.MOD_ID);

    //Method to register my first item
    public static final RegistryObject<Item> PIXILITE_CRYSTAL = ITEMS.register("pixilite_crystal",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.PIXILITE_MOD_TAB)));

    public static final RegistryObject<Item> PIXILITE_INGOT = ITEMS.register("pixilite_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.PIXILITE_MOD_TAB)));

    public static final RegistryObject<Item> PIXILITE_CHEST_FINDER = ITEMS.register("pixilite_chest_finder",
            () -> new PixiliteChestFinderItem(new Item.Properties().tab(ModCreativeModTab.PIXILITE_MOD_TAB).durability(456).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SULIM_SEEDS = ITEMS.register("sulim_seeds",
            () -> new SulimSeedsItem(new Item.Properties().tab(ModCreativeModTab.PIXILITE_MOD_TAB)));

    public static final RegistryObject<Item> COOKED_SULIM_SEEDS = ITEMS.register("cooked_sulim_seeds",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.PIXILITE_MOD_TAB).food(ModFoods.COOKED_SULIM_SEEDS)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
