package com.github.dimadencep.mods.rrls.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "rrls")
public class ModConfig implements ConfigData {
    public boolean enabled = true;
    @ConfigEntry.Gui.Tooltip
    public boolean rgbText = false;
    @ConfigEntry.Gui.Tooltip
    public boolean loadingScreenHide = false;
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public ShowIn showIn = ShowIn.ALL;
    public boolean resetResources = false;
    @ConfigEntry.Gui.Tooltip
    public boolean reInitScreen = true;
    public boolean renderProgressBar = true;
    @ConfigEntry.Gui.Tooltip
    public String reloadText = "rrls.reloadresources";

    public enum ShowIn {
        DISABLED,
        ONLY_GAME,
        ONLY_GUI,
        ALL;

        public boolean canShow(boolean isGame) {
            if (this == DISABLED) return false;

            if (this == ALL) return true;

            if (isGame) {
                return this == ONLY_GAME;
            } else {
                return this == ONLY_GUI;
            }
        }
    }
}