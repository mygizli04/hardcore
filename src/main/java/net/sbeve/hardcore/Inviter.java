package net.sbeve.hardcore;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Inviter implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        if (!player.isOp()) {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }
}
