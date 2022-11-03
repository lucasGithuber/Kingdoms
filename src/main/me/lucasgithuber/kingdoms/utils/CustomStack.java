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

public class CustomItemStack extends ItemStack {

    public CustomItemStack(ItemStack item) {
        super(item);
    }

    public CustomItemStack(Material type) {
        super(type);
    }

    public CustomItemStack(ItemStack item, Consumer<ItemMeta> meta) {
        super(item);
        ItemMeta itemMeta = getItemMeta();
        meta.accept(itemMeta);
        setItemMeta(itemMeta);
    }

    public CustomItemStack(Material type, Consumer<ItemMeta> meta) {
        this(new ItemStack(type), meta);

    }

    public CustomItemStack(ItemStack item, String name, String... lore) {
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

    public CustomItemStack(ItemStack item, Color color, String name, String... lore) {
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

    public CustomItemStack addFlags(ItemFlag... flags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.addItemFlags(flags);
        setItemMeta(itemMeta);

        return this;
    }

    public CustomItemStack setCustomModel(int data) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setCustomModelData(data == 0 ? null : data);
        setItemMeta(itemMeta);

        return this;
    }

    public CustomItemStack(Material type, String name, String... lore) {
        this(new ItemStack(type), name, lore);
    }

    public CustomItemStack(Material type, String name, List<String> lore) {
        this(new ItemStack(type), name, lore.toArray(new String[lore.size()]));
    }

    public CustomItemStack(ItemStack item, List<String> list) {
        this(item, list.get(0), list.subList(1, list.size()).toArray(new String[0]));
    }

    public CustomItemStack(Material type, List<String> list) {
        this(new ItemStack(type), list);
    }

    public CustomItemStack(ItemStack item, int amount) {
        super(item);
        setAmount(amount);
    }

    public CustomItemStack(ItemStack item, Material type) {
        super(item);
        setType(type);
    }

}