package me.lucasgithuber.kingdoms.utils;

import me.lucasgithuber.kingdoms.utils.CustomStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.Color;

@UtilityClass
public class GuiElements {

    public static final CustomStack CLOSE_BUTTON = new CustomStack(
        Material.BARRIER,
        Color.RED + "Close"
    );

    public static final CustomStack GUI_BACKGROUND = new CustomStack(
        Material.BLACK_STAINED_GLASS_PANE,
        " "
    );
}