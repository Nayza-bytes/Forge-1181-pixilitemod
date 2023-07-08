package net.nayza.pixilitemod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PixiliteChestFinderItem extends Item {
    public PixiliteChestFinderItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        if(p_41427_.getLevel().isClientSide()) {
            BlockPos posClicked = p_41427_.getClickedPos();
            Player player = p_41427_.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= posClicked.getY() + 64; i++) {
                Block blockBelow = p_41427_.getLevel().getBlockState(posClicked.below(1)).getBlock();

                if(isChest(blockBelow)) {
                    outputChestCoord(posClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.pixilitemod.pixilite_chest_finder.no_valuable_found"),
                    player.getUUID());
            }
        }

        p_41427_.getItemInHand().hurtAndBreak(1, p_41427_.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(p_41427_);
    }

    private void outputChestCoord(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found" + blockBelow.asItem().getRegistryName().toString() + "at" + "(" + blockPos.getX() + ", " + blockPos.getY()
        + ", " + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isChest(Block block) {
        return block == Blocks.CHEST || block == Blocks.ENDER_CHEST || block == Blocks.TRAPPED_CHEST;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        if(Screen.hasShiftDown()) {
            p_41424_.add(new TranslatableComponent("tooltip.pixilitemod.pixilite_chest_finder.tooltip.shift"));
        } else {
            p_41424_.add(new TranslatableComponent("tooltip.pixilitemod.pixilite_chest_finder.tooltip"));
        }
    }

}
