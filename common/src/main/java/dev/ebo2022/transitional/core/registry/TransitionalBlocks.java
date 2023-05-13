package dev.ebo2022.transitional.core.registry;

import com.mojang.datafixers.util.Pair;
import dev.ebo2022.transitional.common.block.ScarletWeedBlock;
import dev.ebo2022.transitional.common.block.CrocusesBlock;
import dev.ebo2022.transitional.common.block.trees.WindsweptTreeGrower;
import dev.ebo2022.transitional.common.item.TabInsertBlockItem;
import dev.ebo2022.transitional.core.registry.util.Woodset;
import gg.moonflower.pollen.api.block.PollinatedStandingSignBlock;
import gg.moonflower.pollen.api.block.PollinatedWallSignBlock;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedBlockRegistry;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;
import java.util.function.Supplier;

public class TransitionalBlocks {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final PollinatedBlockRegistry BLOCKS = PollinatedRegistry.createBlock(TransitionalItems.ITEMS);


    private static final Woodset ALDER_WOODSET = new Woodset(MaterialColor.TERRACOTTA_WHITE, MaterialColor.COLOR_PURPLE);

    public static final Supplier<Block> CROCUSES = BLOCKS.registerWithItem("crocuses", () -> new CrocusesBlock(BlockBehaviour.Properties.copy(Blocks.ALLIUM)), followItem(Items.WITHER_ROSE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> DELPHINIUM = BLOCKS.registerWithItem("red_delphinium", () -> new FlowerBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.copy(Blocks.ALLIUM)), followItem(Items.WITHER_ROSE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> POTTED_DELPHINIUM = BLOCKS.registerWithItem("potted_red_delphinium", () -> new FlowerPotBlock(DELPHINIUM.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)), followItem(Items.WITHER_ROSE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> SCARLET_WEEDS = BLOCKS.registerWithItem("scarlet_weeds", () -> new ScarletWeedBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)), followItem(Items.WITHER_ROSE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> STRIPPED_ALDER_LOG = BLOCKS.registerWithItem("stripped_alder_log", ALDER_WOODSET::stripped_log, followItem(Items.STRIPPED_WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> STRIPPED_ALDER_WOOD = BLOCKS.registerWithItem("stripped_alder_wood", ALDER_WOODSET::stripped_wood, followItem(Items.STRIPPED_WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> ALDER_LOG = BLOCKS.registerWithItem("alder_log", ALDER_WOODSET::log, followItem(Items.WARPED_STEM, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> ALDER_WOOD = BLOCKS.registerWithItem("alder_wood", ALDER_WOODSET::wood, followItem(Items.WARPED_HYPHAE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> ALDER_PLANKS = BLOCKS.registerWithItem("alder_planks", ALDER_WOODSET::planks, followItem(Items.WARPED_PLANKS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> ALDER_SLAB = BLOCKS.registerWithItem("alder_slab", ALDER_WOODSET::slab, followItem(Items.WARPED_SLAB, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> ALDER_STAIRS = BLOCKS.registerWithItem("alder_stairs", () -> ALDER_WOODSET.stairs(ALDER_PLANKS), followItem(Items.WARPED_STAIRS, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final Supplier<Block> ALDER_PRESSURE_PLATE = BLOCKS.registerWithItem("alder_pressure_plate", ALDER_WOODSET::pressurePlate, followItem(Items.WARPED_PRESSURE_PLATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> ALDER_BUTTON = BLOCKS.registerWithItem("alder_button", ALDER_WOODSET::button, followItem(Items.WARPED_BUTTON, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> ALDER_FENCE = BLOCKS.registerWithItem("alder_fence", ALDER_WOODSET::fence, followItem(Items.WARPED_FENCE, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> ALDER_FENCE_GATE = BLOCKS.registerWithItem("alder_fence_gate", ALDER_WOODSET::fenceGate, followItem(Items.WARPED_FENCE_GATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> ALDER_DOOR = BLOCKS.registerWithItem("alder_door", ALDER_WOODSET::door, followItem(Items.WARPED_DOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Supplier<Block> ALDER_TRAPDOOR = BLOCKS.registerWithItem("alder_trapdoor", ALDER_WOODSET::trapdoor, followItem(Items.WARPED_TRAPDOOR, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final Pair<Supplier<PollinatedStandingSignBlock>, Supplier<PollinatedWallSignBlock>> ALDER_SIGN = BLOCKS.registerSign("alder", Material.WOOD, MaterialColor.COLOR_BROWN);
    public static final Supplier<Block> ALDER_LEAVES = BLOCKS.registerWithItem("alder_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)), followItem(Items.FLOWERING_AZALEA_LEAVES, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> ALDER_SAPLING = BLOCKS.registerWithItem("alder_sapling", () -> new SaplingBlock(new WindsweptTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), followItem(Items.DARK_OAK_SAPLING, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> POTTED_ALDER_SAPLING = BLOCKS.register("potted_alder_sapling", createFlowerPot(ALDER_SAPLING));

    public static final Supplier<Block> SCARLET_GRASS = BLOCKS.registerWithItem("scarlet_grass", () -> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    private static Supplier<Block> createFlowerPot(Supplier<Block> block) {
        return () -> new FlowerPotBlock(block.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM));
    }

    private static Function<Block, Item> followItem(Item insertAfter, Item.Properties properties) {
        return object -> new TabInsertBlockItem(insertAfter, object, properties);
    }

    public static void load(Platform platform) {
        LOGGER.debug("Registered to platform");
        BLOCKS.register(platform);
    }
}
