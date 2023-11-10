package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.CustomPlayer;
import be.creajojo.creajojopluginv1.database.BaseDAO;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO extends BaseDAO{


    public int savePlayer(CustomPlayer player) {
        int execute = 0;

        try{
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO Player (PlayerName, PlayTime) VALUES (?, ?)");

            statement.setString(1, player.getName());
            statement.setDouble(2, player.getPlayTime());

            execute = statement.executeUpdate();
        }catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }
        return execute;
    }

    public CustomPlayer getPlayerByName(String name) {
        CustomPlayer player = null;

        try{
            PreparedStatement statement = getConnection().prepareStatement("SELECT Id, PlayerName, PlayTime FROM Player WHERE PlayerName = ?");

            statement.setString(1, name);

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                player = new CustomPlayer(set.getInt(1), set.getString(2), set.getDouble(3));
            }
        }catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }

        return player;
    }

    public CustomPlayer getOrCreatePlayer(CustomPlayer player) {
        Bukkit.getLogger().info("Get or create player");
        CustomPlayer dbPlayer = getPlayerByName(player.getName());
        if (dbPlayer == null) {
            Bukkit.getLogger().info("Player not found in database, creating new player");
            dbPlayer = player;
            savePlayer(player);
        }else{
            Bukkit.getLogger().info("Player found in database");
        }
        return dbPlayer;
    }


    public int updatePlayTime(double playTime, String name) {
        int execute = 0;
        try{
            PreparedStatement statement = getConnection().prepareStatement("UPDATE Player SET PlayTime = ? WHERE PlayerName = ?");

            statement.setDouble(1, playTime);
            statement.setString(2, name);

            execute = statement.executeUpdate();
        }catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }
        return execute;
    }

}
