package me.lucasgithuber.kingdoms.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Crown {

    public static ItemStack crown;

    public static void init() {
        createCrown();
    }

    private static void createCrown() {
        ItemStack item = new ItemStack(Material.GOLDEN_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Crown");
        List<String> lore = new ArrayList<>();
        lore.add("§7Crown that makes particles");
        meta.setUnbreakable(true);
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        crown = item;
    }
}