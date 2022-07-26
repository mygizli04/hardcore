package net.sbeve.hardcore;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathHandler implements Listener {

    ArrayList<DeadPlayer> deadPlayers = new ArrayList<>();
    
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = (Player)event.getEntity();

        Location playerLocation = player.getLocation();

        DeadPlayer playerData = new DeadPlayer();

        playerData.player = player;

        playerData.deathLocation = playerLocation;

        deadPlayers.add(playerData);

        player.sendMessage("you died at " + playerLocation.getX() + " " + playerLocation.getY() + " " + playerLocation.getZ());
    }
}

class DeadPlayer {
    Player player;

    Location deathLocation;
} 