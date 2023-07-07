package net.nayza.pixilitemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab PIXILITE_MOD_TAB = new CreativeModeTab("pixilitemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PIXILITE_INGOT.get());
        }
    };
}
