package dev.ebo2022.transitional.common.block.trees;

import dev.ebo2022.transitional.core.Transitional;
import dev.ebo2022.transitional.core.registry.TransitionalFeatures;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WindsweptTreeGrower extends ModTreeGrower {
    @Override
    protected ResourceLocation getConfiguredFeatureLocation() {
        return Transitional.location("windswept_tree");
    }
}
