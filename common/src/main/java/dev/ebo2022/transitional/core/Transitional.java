package dev.ebo2022.transitional.core;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.ebo2022.transitional.core.registry.*;
import gg.moonflower.pollen.api.event.events.client.render.FogEvents;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.client.ColorRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import gg.moonflower.pollen.api.registry.content.CompostablesRegistry;
import gg.moonflower.pollen.api.registry.content.FlammabilityRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ebo2022
 * Created: 8/24/22
 */
public class Transitional {

    public static final String MOD_ID = "transitional";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(() -> Transitional::clientInit)
            .clientPostInit(() -> Transitional::clientPostInit)
            .commonInit(Transitional::commonInit)
            .commonPostInit(Transitional::commonPostInit)
            .build();

    public static void clientInit() {
        ColorRegistry.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), TransitionalBlocks.ALDER_LEAVES);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor(), TransitionalBlocks.ALDER_LEAVES);
    }

    public static void clientPostInit(Platform.ModSetupContext ctx) {
        RenderTypeRegistry.register(TransitionalBlocks.CROCUSES.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.ALDER_SAPLING.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.ALDER_DOOR.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.ALDER_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.POTTED_ALDER_SAPLING.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.DELPHINIUM.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.POTTED_DELPHINIUM.get(), RenderType.cutout());
        RenderTypeRegistry.register(TransitionalBlocks.SCARLET_WEEDS.get(), RenderType.cutout());
    }

    public static void commonInit() {
        TransitionalBlocks.load(PLATFORM);
        TransitionalItems.load(PLATFORM);
        TransitionalBoatTypes.load(PLATFORM);
        TransitionalFeatures.load(PLATFORM);
    }

    public static void commonPostInit(Platform.ModSetupContext ctx) {
        ctx.enqueueWork(() -> {
            StrippingRegistry.register(TransitionalBlocks.ALDER_LOG.get(), TransitionalBlocks.STRIPPED_ALDER_LOG.get());
            StrippingRegistry.register(TransitionalBlocks.ALDER_WOOD.get(), TransitionalBlocks.STRIPPED_ALDER_WOOD.get());

            CompostablesRegistry.register(TransitionalBlocks.ALDER_LEAVES.get(), 0.3F);
            CompostablesRegistry.register(TransitionalBlocks.ALDER_SAPLING.get(), 0.3F);

            FlammabilityRegistry.register(TransitionalBlocks.ALDER_LEAVES.get(), 30, 60);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_LOG.get(), 5, 5);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_WOOD.get(), 5, 5);
            FlammabilityRegistry.register(TransitionalBlocks.STRIPPED_ALDER_LOG.get(), 5, 5);
            FlammabilityRegistry.register(TransitionalBlocks.STRIPPED_ALDER_WOOD.get(), 5, 5);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_PLANKS.get(), 5, 20);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_SLAB.get(), 5, 20);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_STAIRS.get(), 5, 20);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_FENCE.get(), 5, 20);
            FlammabilityRegistry.register(TransitionalBlocks.ALDER_FENCE_GATE.get(), 5, 20);
        });
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
