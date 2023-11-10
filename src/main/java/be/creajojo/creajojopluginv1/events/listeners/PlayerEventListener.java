package be.creajojo.creajojopluginv1.events.listeners;

import be.creajojo.creajojopluginv1.Models.CustomPlayer;
import be.creajojo.creajojopluginv1.database.daos.PlayerDAO;
import be.creajojo.creajojopluginv1.services.PlayerService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Get the current player
        Player player = event.getPlayer();

        // Get or create the player from/to the database
        CustomPlayer customPlayer = CustomPlayer.fromMinecraftPlayer(player);

        PlayerDAO playerDAO = new PlayerDAO();
        CustomPlayer dbPlayer = playerDAO.getOrCreatePlayer(customPlayer);




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



        //Load buff
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // Get the player who left
        Player player = event.getPlayer();

        // Update player time
        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.updatePlayTime((double) player.getStatistic(Statistic.PLAY_ONE_MINUTE), player.getName());

        // Write a message to the server console
        System.out.println(player.getName() + " has left the server.");
    }


    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {

        String playerName = "";

        if (event.getDamager() instanceof org.bukkit.entity.Player) {
            // Add 0.5 extra damage to the original damage
            double newDamage = event.getDamage() + 0.5;
            event.setDamage(newDamage);
        }
    }



}
