package dev.ebo2022.transitional.core.fabric;

import dev.ebo2022.transitional.core.Transitional;
import dev.ebo2022.transitional.core.registry.TransitionalFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

/**
 * @author ebo2022
 * Created: 8/17/22
 */
public class TransitionalFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Transitional.PLATFORM.setup();
    }
}
