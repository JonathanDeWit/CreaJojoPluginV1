package be.creajojo.creajojopluginv1.events.listeners;

import be.creajojo.creajojopluginv1.services.PlayerService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Get the current player
        Player player = event.getPlayer();

        // Determine color name
        ChatColor color = PlayerService.getInstance().getColorBasedOnPlaytime(player);

        // Change the username's color
        String coloredName = color + player.getName() + ChatColor.RESET;



        // Set the player display name
        Bukkit.getLogger().info("Change player name color to "+coloredName);
        // Change chat color
        player.setDisplayName(coloredName);
        // Change player list name
        player.setPlayerListName(coloredName);

    }

}
