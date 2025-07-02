package com.saad.ultraswords.swords;



import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class RedStone implements Listener {

    private final JavaPlugin plugin;
    public static final String NAME = ChatColor.RED + "Redstone Sword";

    public RedStone(JavaPlugin plugin) {
        this.plugin = plugin;
        register_Recipe();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private void register_Recipe()
    
    {
        ItemStack redstoneSword = getItem();

        NamespacedKey key = new NamespacedKey(plugin, "redstone_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, redstoneSword);
        recipe.shape(" R ", " R ", " S ");
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }

    public static ItemStack getItem() {
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = sword.getItemMeta();

        meta.setDisplayName("§cRedstone Sword");
        meta.setCustomModelData(101);
        meta.setLore(Arrays.asList(ChatColor.GRAY + "Right-click to create fire!"));
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);

        sword.setItemMeta(meta);
        return sword;
    }



    
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.hasItemMeta())

        {

            ItemMeta meta = item.getItemMeta();
            if (meta != null && NAME.equals(meta.getDisplayName())) {
                Location loc = player.getTargetBlockExact(5).getLocation().add(0, 1, 0);
                loc.getBlock().setType(Material.FIRE);
                player.getWorld().playSound(loc, Sound.ITEM_FLINTANDSTEEL_USE, 1.0f, 1.0f);
            }

        }


    }



}
