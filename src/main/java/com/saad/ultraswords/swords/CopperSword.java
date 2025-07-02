package com.saad.ultraswords.swords;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class CopperSword {

    private final JavaPlugin plugin;

    public CopperSword(JavaPlugin plugin) {
        this.plugin = plugin;
        registerRecipe(plugin);
    }

    public static ItemStack create(JavaPlugin plugin) {
        ItemStack item = new ItemStack(Material.IRON_SWORD);

        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("§6Copper Sword");

            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,
                new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 6.5, AttributeModifier.Operation.ADD_NUMBER));
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,
                new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.0, AttributeModifier.Operation.ADD_NUMBER));

            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "copper_sword"), PersistentDataType.INTEGER, 1);

            item.setItemMeta(meta);
        }

        return item;
    }

    public static void registerRecipe(JavaPlugin plugin) {
        ItemStack result = create(plugin);

        NamespacedKey key = new NamespacedKey(plugin, "copper_sword_recipe");
        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape(" C ", " C ", " S ");
        recipe.setIngredient('C', Material.COPPER_INGOT);
        recipe.setIngredient('S', Material.STICK);

        plugin.getServer().addRecipe(recipe);
    }
}
