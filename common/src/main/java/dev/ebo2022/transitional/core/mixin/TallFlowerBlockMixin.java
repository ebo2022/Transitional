package dev.ebo2022.transitional.core.mixin;

import dev.ebo2022.transitional.core.registry.TransitionalBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TallFlowerBlock.class)
public class TallFlowerBlockMixin extends DoublePlantBlock {

    public TallFlowerBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return super.mayPlaceOn(blockState, blockGetter, blockPos) || blockState.is(TransitionalBlocks.SCARLET_GRASS.get());
    }
}
