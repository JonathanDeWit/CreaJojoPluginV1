package be.creajojo.creajojopluginv1.services;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlayerService {

    private static PlayerService instance;

    // 2. Private constructor
    private PlayerService() {

    }

    public static PlayerService getInstance() {
        if (instance == null) {
            instance = new PlayerService();
        }
        return instance;
    }

    public ChatColor getColorBasedOnPlaytime(Player player) {
        // Get player playtime in hours
        double playTimeInHours = (double) player.getStatistic(Statistic.PLAY_ONE_MINUTE) / (20 * 60 * 60);

        // Return write color corresponding to playtime.
        if (playTimeInHours > 10) {
            Bukkit.getLogger().info("Player playtime: 10");
            return ChatColor.DARK_GREEN;
        } else if (playTimeInHours > 25) {
            Bukkit.getLogger().info("Player playtime: 25");
            return ChatColor.YELLOW;
        } else if (playTimeInHours > 50) {
            Bukkit.getLogger().info("Player playtime: 50");
            return ChatColor.GOLD;
        } else if (playTimeInHours > 75) {
            Bukkit.getLogger().info("Player playtime: 50");
            return ChatColor.DARK_RED;
        } else if (playTimeInHours > 100) {
            Bukkit.getLogger().info("Player playtime: 100");
            return ChatColor.DARK_PURPLE;
        } else {
            Bukkit.getLogger().info("Player playtime is lower than 10");
            return ChatColor.WHITE;
        }
    }

}
