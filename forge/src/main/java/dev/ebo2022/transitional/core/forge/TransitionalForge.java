package dev.ebo2022.transitional.core.forge;

import dev.ebo2022.transitional.core.Transitional;
import net.minecraftforge.fml.common.Mod;

@Mod(Transitional.MOD_ID)
public class TransitionalForge {

    public TransitionalForge() {
        Transitional.PLATFORM.setup();
    }
}