package net.sbeve.hardcore;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
