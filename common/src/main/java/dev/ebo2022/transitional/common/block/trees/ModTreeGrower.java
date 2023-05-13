package dev.ebo2022.transitional.common.block.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

// Borrowed from Ecologics
public abstract class ModTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_222910_, boolean p_222911_) {
        return null;
    }

    protected abstract ResourceLocation getConfiguredFeatureLocation();

    @Override
    public boolean growTree(ServerLevel level, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random) {
        Optional<Holder<ConfiguredFeature<?, ?>>> optional = level.registryAccess().registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY).getHolder(
                ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, getConfiguredFeatureLocation()));
        if (optional.isEmpty()) {
            return false;
        } else {
            ConfiguredFeature<?, ?> configuredfeature = optional.get().value();
            BlockState blockstate = level.getFluidState(pos).createLegacyBlock();
            level.setBlock(pos, blockstate, 4);
            if (configuredfeature.place(level, chunkGenerator, random, pos)) {
                if (level.getBlockState(pos) == blockstate) {
                    level.sendBlockUpdated(pos, state, blockstate, 2);
                }

                return true;
            } else {
                level.setBlock(pos, state, 4);
                return false;
            }
        }
    }
}