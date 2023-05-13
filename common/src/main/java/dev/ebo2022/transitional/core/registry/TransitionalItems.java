package dev.ebo2022.transitional.core.registry;

import dev.ebo2022.transitional.core.Transitional;
import gg.moonflower.pollen.api.item.PollinatedBoatItem;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class TransitionalItems {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Transitional.MOD_ID);

    public static final Supplier<Item> WINDSWEPT_BOAT = ITEMS.register("windswept_boat", () -> new PollinatedBoatItem(TransitionalBoatTypes.WINDSWEPT, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));

    public static void load(Platform platform) {
        LOGGER.debug("Registered to platform");
        ITEMS.register(platform);
    }
}
