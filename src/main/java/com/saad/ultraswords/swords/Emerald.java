package com.saad.ultraswords.swords;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.UUID;





public class Emerald {

    private final JavaPlugin plugin;

    public Emerald(JavaPlugin plugin) {
        this.plugin = plugin;
        register(plugin);
    }

    public static void register(JavaPlugin plugin) {
        ItemStack emeraldSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = emeraldSword.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("§aEmerald Sword");
            meta.setCustomModelData(2);
            meta.setLore(Arrays.asList("§7Same power as Diamond", "§7Durability of Iron"));


            AttributeModifier damageModifier = new AttributeModifier(
                    UUID.randomUUID(),
                    "generic.attack_damage",
                    7.0,
                    AttributeModifier.Operation.ADD_NUMBER
            );
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);




            AttributeModifier speedModifier = new AttributeModifier(
                    UUID.randomUUID(),
                    "generic.attack_speed",
                    -2.4,
                    AttributeModifier.Operation.ADD_NUMBER
            );
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speedModifier);


            if (meta instanceof Damageable) {
                Damageable damageable = (Damageable) meta;
                int maxDiamondDurability = Material.DIAMOND_SWORD.getMaxDurability();
                int desiredDurability = maxDiamondDurability - 1311; // 1561 - 250 = 1311
                damageable.setDamage(desiredDurability);
                meta = (ItemMeta) damageable;
            }


            NamespacedKey idKey = new NamespacedKey(plugin, "emerald_sword_id");
            meta.getPersistentDataContainer().set(idKey, PersistentDataType.INTEGER, 1);

            emeraldSword.setItemMeta(meta);
        }


        
        NamespacedKey key = new NamespacedKey(plugin, "emerald_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, emeraldSword);
        recipe.shape(" E ", " E ", " S ");
        recipe.setIngredient('E', Material.EMERALD);
        recipe.setIngredient('S', Material.STICK);




        plugin.getServer().addRecipe(recipe);
    }













}
