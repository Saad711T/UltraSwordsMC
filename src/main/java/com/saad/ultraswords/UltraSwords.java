package com.saad.ultraswords;

import org.bukkit.plugin.java.JavaPlugin;
import com.saad.ultraswords.swords.RedStone;
import com.saad.ultraswords.swords.CopperSword;
import com.saad.ultraswords.swords.Emerald;
import com.saad.ultraswords.swords.Obsidian;

public class UltraSwords extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("UltraSwords has been enabled!");


        

        new RedStone(this);
        new CopperSword(this);
        new Obsidian(this);
        new Emerald(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("UltraSwords has been disabled.");
    }
}
