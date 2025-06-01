package net.strifaru.sarthrakmod.item.custom;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SMBladeItem extends Item {
    public SMBladeItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState originalBlock = level.getBlockState(pos);

        // Ne pas affecter l'air
        if (originalBlock.getBlock() == Blocks.AIR) {
            return InteractionResult.PASS;
        }

        // Seulement côté serveur
        if (!level.isClientSide) {
            // Remplacer le bloc par de l'air
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

            pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                    item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            level.playSound(null, pContext.getClickedPos(), SoundEvents.WIND_CHARGE_THROW, SoundSource.BLOCKS);

            // Créer un timer pour remettre le bloc après 3 secondes
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // Remettre le bloc original
                    level.setBlock(pos, originalBlock, 3);
                    timer.cancel();
                }
            }, 3000); // 3000 millisecondes = 3 secondes
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.sarthrakmod.sartherion_blade.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.sarthrakmod.sartherion_blade"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
