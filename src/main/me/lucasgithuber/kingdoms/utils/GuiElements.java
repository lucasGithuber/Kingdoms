package me.lucasgithuber.kingdoms.utils;

import me.lucasgithuber.kingdoms.utils.CustomStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.Color;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public class GuiElements {

        public static final CustomStack GUI_BACKGROUND = new CustomStack(
        Material.BLACK_STAINED_GLASS_PANE,
        " "
    );

    public static final CustomStack CLOSE_BUTTON = new CustomStack(
        Material.BARRIER,
        ChatColor.RED + "Close"
    );

    public static final CustomStack CLOSE_OPTION = new CustomStack(
        Material.RED_STAINED_GLASS_PANE,
        ChatColor.GRAY + "Close"
    );

    public static final CustomStack BLUE_HELIX_OPTION = new CustomStack(
        Material.TWISTING_VINES,
        ChatColor.BLUE + "Blue helix particles"
    );

    public static final CustomStack RED_HELIX_OPTION = new CustomStack(
        Material.WEEPING_VINES,
        ChatColor.RED + "Red helix particles"
    );

    public static final CustomStack STRING_OPTION = new CustomStack(
        Material.STRING,
        ChatColor.WHITE + "White spiral particles"
    );
}