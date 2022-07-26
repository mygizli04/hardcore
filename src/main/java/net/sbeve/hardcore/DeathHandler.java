package net.sbeve.hardcore;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathHandler implements Listener {

    ArrayList<DeadPlayer> deadPlayers = new ArrayList<>();
    
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Main main = JavaPlugin.getPlugin(Main.class);

        Player player = (Player)event.getEntity();

        if (player.getGameMode() == GameMode.SPECTATOR) {
            player.sendMessage("Literally how did you manage to die in spectator mode lmao");
            return;
        }

        Location playerLocation = player.getLocation();

        while (playerLocation.getBlock().getType() == Material.LAVA) {
            playerLocation = playerLocation.add(0, 1, 0);
        }

        playerLocation.getBlock().setType(Material.PLAYER_HEAD);

        Skull playerSkull = (Skull)playerLocation.getBlock().getState();

        playerSkull.setOwningPlayer(main.getServer().getOfflinePlayer(player.getUniqueId()));

        playerSkull.update();

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