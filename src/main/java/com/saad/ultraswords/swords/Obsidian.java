package com.saad.ultraswords.swords;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Obsidian {




    private final JavaPlugin plugin;

    public Obsidian(JavaPlugin plugin) {
        this.plugin = plugin;
        register(plugin);




    }

    public static void register(JavaPlugin plugin) {
        ItemStack obsidianSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = obsidianSword.getItemMeta();
        meta.setDisplayName("§8Obsidian Sword");
        meta.setCustomModelData(2);
        obsidianSword.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(plugin, "obsidian_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, obsidianSword);
        recipe.shape(" O ", " O ", " S ");

        
        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('S', Material.STICK);

        plugin.getServer().addRecipe(recipe);
    }
}
