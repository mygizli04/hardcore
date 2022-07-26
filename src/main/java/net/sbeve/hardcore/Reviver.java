package net.sbeve.hardcore;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Reviver {

    public Reviver() {
        Main main = JavaPlugin.getPlugin(Main.class);

        BukkitScheduler scheduler = main.getServer().getScheduler();
        
        scheduler.scheduleSyncRepeatingTask(main, new Runnable() {

            @Override
            public void run() {
               main.getServer().getOnlinePlayers().forEach(player -> {

                    Location playerLocation = player.getLocation();

                    ArrayList<DeadPlayer> revivedPlayers = new ArrayList<>();
                    
                    main.deathHandler.deadPlayers.forEach(deadPlayer -> {
                        if (player.getGameMode() == GameMode.SPECTATOR) {
                            return;
                        }

                        if (!((deadPlayer.deathLocation.getX() - 5 < playerLocation.getX()) && (playerLocation.getX() < deadPlayer.deathLocation.getX() + 5))) {
                            return;
                        }

                        if (!((deadPlayer.deathLocation.getY() - 5 < playerLocation.getY()) && (playerLocation.getY() < deadPlayer.deathLocation.getY() + 5))) {
                            return;
                        }

                        if (!((deadPlayer.deathLocation.getZ() - 5 < playerLocation.getZ()) && (playerLocation.getZ() < deadPlayer.deathLocation.getZ() + 5))) {
                            return;
                        }

                        deadPlayer.player.teleport(deadPlayer.deathLocation);

                        deadPlayer.deathLocation.getBlock().setType(Material.AIR);

                        deadPlayer.player.setGameMode(GameMode.SURVIVAL);

                        revivedPlayers.add(deadPlayer);
                    });

                    main.deathHandler.deadPlayers.removeAll(revivedPlayers);
               });
            }


        }, 0L, 10L);
    }

}
