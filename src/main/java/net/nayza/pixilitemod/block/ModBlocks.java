package net.nayza.pixilitemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayza.pixilitemod.PixiliteMod;
import net.nayza.pixilitemod.item.ModCreativeModTab;
import net.nayza.pixilitemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PixiliteMod.MOD_ID);


    public static final RegistryObject<Block> PIXILITE_BLOCK = registerBlock("pixilite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(1f).requiresCorrectToolForDrops().explosionResistance(15)), ModCreativeModTab.PIXILITE_MOD_TAB);

    public static final RegistryObject<Block> PIXILITE_ORE = registerBlock("pixilite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().explosionResistance(12)), ModCreativeModTab.PIXILITE_MOD_TAB);

    public static final RegistryObject<Block> DEEPSLATE_PIXILITE_ORE = registerBlock("deepslate_pixilite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().explosionResistance(12)), ModCreativeModTab.PIXILITE_MOD_TAB);





    //Create the blocks
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Create the block item for the blocks
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
