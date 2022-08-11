package net.sbeve.hardcore;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Tracker implements Listener {
    public static HashMap<Player, Location> lastLocations = new HashMap<>();

    @EventHandler
    public void onStep(PlayerMoveEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();

        if (from.getX() == to.getX() && from.getY() == to.getY() && from.getZ() == to.getZ()) {
            return;
        }

        // If the block below the player is air, return
        if (to.getBlock().getRelative(0, -1, 0).getType().isAir()) {
            return;
        }

        lastLocations.put(event.getPlayer(), to);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        lastLocations.put(event.getPlayer(), event.getPlayer().getLocation());
    }
}
