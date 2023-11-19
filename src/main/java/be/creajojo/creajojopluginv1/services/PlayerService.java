package be.creajojo.creajojopluginv1.services;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.Models.CustomPlayer;
import be.creajojo.creajojopluginv1.Models.PlayerBuff;
import be.creajojo.creajojopluginv1.database.daos.BuffDAO;
import be.creajojo.creajojopluginv1.database.daos.PlayerBuffDAO;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class PlayerService {

    private final float defaultSpeed = 0.20f;

    //Default duration in seconds (5 minutes)
    private final int defaultDuration = 300;

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


    // To have the default speed put speedIncrease to 1
    public void changeSpeed(Player player, Float speedIncrease) throws Exception {

        // Calculate the new speed based on the speedIncrease
        float newSpeed = defaultSpeed * speedIncrease;


        if (newSpeed >= 0 && newSpeed <= 2){
            // Change player speed
            player.setWalkSpeed(newSpeed);
        }
        else {
            throw new Exception("Walk speed should be between 0 and 2");
        }
    }

    // Add jump boost potion effect
    public boolean addJumpBoost(Player player){
        // Check if player already has the potion effect
        if (!player.hasPotionEffect(PotionEffectType.JUMP)) {
            // Mage the potion effect
            PotionEffect jumpBoost = new PotionEffect(PotionEffectType.JUMP, defaultDuration * 20, 1);
            // Add potion effect to player
            player.addPotionEffect(jumpBoost);
            return true;
        }
        else
            return false;
    }

    // Remove jup boost potion effect
    public void removeJumpBoost(Player player){
        // Check if player has the potion effect
        if (player.hasPotionEffect(PotionEffectType.JUMP)) {
            // Remove jump boost effect
            player.removePotionEffect(PotionEffectType.JUMP);
        }
    }


    public ArrayList<PlayerBuff> getOrCreatePlayerBuffs(CustomPlayer player){
        PlayerBuffDAO playerBuffDAO = new PlayerBuffDAO();
        BuffDAO buffDAO = new BuffDAO();


        int playerBuffCount =  playerBuffDAO.count(player.getId());
        int buffCount = buffDAO.count();

        if (playerBuffCount < buffCount){
            ArrayList<Buff> buffs = buffDAO.getRecentBuffs(player.getLastUpdate());
            playerBuffDAO.saveDefaultPlayerBuffs(player.getId(), buffs);
        }

        ArrayList<PlayerBuff> playerBuffs = playerBuffDAO.getPlayerBuffByPlayerId(player.getId());

        return  playerBuffs;
    }
}
