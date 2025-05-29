package net.strifaru.sarthrakmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.strifaru.sarthrakmod.SarthrakMod;
import net.strifaru.sarthrakmod.block.SMBlocks;

public class SMBlockStateProvider extends BlockStateProvider {
    public SMBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SarthrakMod.MOD_ID, exFileHelper);
    }



    @Override
    protected void registerStatesAndModels() {
        blockWithItem(SMBlocks.SARTHERION_BLOCK);
        blockWithItem(SMBlocks.ARCANE_CATALYST);

    }





    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
