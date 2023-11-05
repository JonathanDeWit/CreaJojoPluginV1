package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.Player;
import be.creajojo.creajojopluginv1.database.BaseDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO extends BaseDAO{


    public int savePlayer(Player player) {
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

    public Player getPlayerByName(String name) {
        Player player = null;

        try{
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Player WHERE PlayerName = ?");

            statement.setString(1, name);

            ResultSet set = statement.executeQuery();

            player = new Player(set.getInt(1), set.getString(2), set.getDouble(3));
        }catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
            exception.printStackTrace();
        }

        return player;
    }
}
