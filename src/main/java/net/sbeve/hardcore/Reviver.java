package net.sbeve.hardcore;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Reviver {

    public Reviver() {
        Main main = JavaPlugin.getPlugin(Main.class);

        BukkitScheduler scheduler = main.getServer().getScheduler();
        
        scheduler.scheduleSyncRepeatingTask(main, new Runnable() {

            @Override
            public void run() {
                // Do nothing for now
            }

        }, 0L, 10L);
    }

}
