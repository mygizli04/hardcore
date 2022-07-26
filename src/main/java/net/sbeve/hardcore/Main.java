package net.sbeve.hardcore;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class Main extends JavaPlugin {
    DeathHandler deathHandler = new DeathHandler();

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");

        getServer().getPluginManager().registerEvents(deathHandler, this);
    }
    
}
