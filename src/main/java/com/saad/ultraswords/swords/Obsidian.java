package com.saad.ultraswords.swords;



import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.UUID;


public class Obsidian {

    private final JavaPlugin plugin;

    public Obsidian(JavaPlugin plugin) {
        this.plugin = plugin;
        register(plugin);
    }

    public static void register(JavaPlugin plugin) {
        ItemStack obsidianSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = obsidianSword.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("§5Obsidian Sword");
            meta.setCustomModelData(3); // اجعلها مختلفة عن سيف الزمرد
            meta.setLore(Arrays.asList("§7Forged from the hardest material", "§7Heavy but deadly"));

            AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 9.0, AttributeModifier.Operation.ADD_NUMBER);
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);



            AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -2.8, AttributeModifier.Operation.ADD_NUMBER);
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);





            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.setUnbreakable(true); // اجعل السيف لا ينكسر (اختياري)
            meta.setLore(Arrays.asList("§7§oVery durable and sharp"));

            if (meta instanceof Damageable) {
                Damageable damageable = (Damageable) meta;
                int maxDurability = Material.DIAMOND_SWORD.getMaxDurability();
                int desiredDurability = maxDurability - 500; // تقريبًا 2000 تحمل
                damageable.setDamage(desiredDurability);
                meta = (ItemMeta) damageable;
            }




            NamespacedKey idKey = new NamespacedKey(plugin, "obsidian_sword_id");
            meta.getPersistentDataContainer().set(idKey, PersistentDataType.INTEGER, 1);

            obsidianSword.setItemMeta(meta);
        }

        


        NamespacedKey key = new NamespacedKey(plugin, "obsidian_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, obsidianSword);
        recipe.shape(" O ", " O ", " S ");
        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('S', Material.STICK);

        plugin.getServer().addRecipe(recipe);
    }


}
