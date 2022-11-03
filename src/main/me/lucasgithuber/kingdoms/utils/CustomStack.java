package me.lucasgithuber.kingdoms.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

public class CustomStack extends ItemStack {

    public CustomStack(ItemStack item) {
        super(item);
    }

    public CustomStack(Material type) {
        super(type);
    }

    public CustomStack(ItemStack item, Consumer<ItemMeta> meta) {
        super(item);
        ItemMeta itemMeta = getItemMeta();
        meta.accept(itemMeta);
        setItemMeta(itemMeta);
    }

    public CustomStack(Material type, Consumer<ItemMeta> meta) {
        this(new ItemStack(type), meta);

    }

    public CustomStack(ItemStack item, String name, String... lore) {
        this(item, itemMeta -> {
            if (name != null) {
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            }

            if (lore.length > 0) {
                List<String> lines = new ArrayList<>();

                for (String line : lore) {
                    lines.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                itemMeta.setLore(lines);
            }
        });
    }

    public CustomStack(ItemStack item, Color color, String name, String... lore) {
        this(item, itemMeta -> {
            if (name != null) {
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            }

            if (lore.length > 0) {
                List<String> lines = new ArrayList<>();

                for (String line : lore) {
                    lines.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                itemMeta.setLore(lines);
            }
            if (itemMeta instanceof PotionMeta) {
                ((PotionMeta) itemMeta).setColor(color);
            }
        });
    }

    public CustomStack addFlags(ItemFlag... flags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.addItemFlags(flags);
        setItemMeta(itemMeta);

        return this;
    }

    public CustomStack setCustomModel(int data) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setCustomModelData(data == 0 ? null : data);
        setItemMeta(itemMeta);

        return this;
    }

    public CustomStack(Material type, String name, String... lore) {
        this(new ItemStack(type), name, lore);
    }

    public CustomStack(Material type, String name, List<String> lore) {
        this(new ItemStack(type), name, lore.toArray(new String[lore.size()]));
    }

    public CustomStack(ItemStack item, List<String> list) {
        this(item, list.get(0), list.subList(1, list.size()).toArray(new String[0]));
    }

    public CustomStack(Material type, List<String> list) {
        this(new ItemStack(type), list);
    }

    public CustomStack(ItemStack item, int amount) {
        super(item);
        setAmount(amount);
    }

    public CustomStack(ItemStack item, Material type) {
        super(item);
        setType(type);
    }

}