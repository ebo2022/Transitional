package dev.ebo2022.transitional.core.registry;

import dev.ebo2022.transitional.core.Transitional;
import gg.moonflower.pollen.api.PollenRegistries;
import gg.moonflower.pollen.api.entity.PollinatedBoatType;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class TransitionalBoatTypes {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final PollinatedRegistry<PollinatedBoatType> BOAT_TYPES = PollinatedRegistry.create(PollenRegistries.BOAT_TYPE_REGISTRY, Transitional.MOD_ID);
    public static final Supplier<PollinatedBoatType> WINDSWEPT = BOAT_TYPES.register("windswept_boat", () -> new PollinatedBoatType(Transitional.location("textures/entity/boat/alder.png")));

    public static void load(Platform platform) {
        LOGGER.debug("Registered to platform");
        BOAT_TYPES.register(platform);
    }
}
