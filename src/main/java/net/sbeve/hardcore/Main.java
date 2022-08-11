package net.sbeve.hardcore;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class Main extends JavaPlugin {
    DeathHandler deathHandler = new DeathHandler();
    Inviter inviter = new Inviter();
    Tracker tracker = new Tracker();

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");

        new Reviver();
        

        getServer().getPluginManager().registerEvents(deathHandler, this);
        getServer().getPluginManager().registerEvents(inviter, this);
        getServer().getPluginManager().registerEvents(tracker, this);
    }
    
}
