package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.Models.PlayerBuff;
import be.creajojo.creajojopluginv1.database.BaseDAO;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerBuffDAO extends BaseDAO
{
    public int save(PlayerBuff playerBuff) {
        Bukkit.getLogger().info("PlayerBuffDAO save");
        int execute = 0;

        try{
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO player_buff (BuffId, PlayerId, Improvement) VALUES (?, ?, ?)");

            statement.setInt(1, playerBuff.getBuffId());
            statement.setInt(2, playerBuff.getPlayerId());
            statement.setFloat(3, playerBuff.getImprovement());

            execute = statement.executeUpdate();
        }catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }

    public int saveDefaultPlayerBuffs(int playerId, ArrayList<Buff> buffs) {
        Bukkit.getLogger().info("PlayerBuffDAO saveDefaultPlayerBuffs");
        int execute = 0;

        try{
            String baseSQL = "INSERT INTO player_buff (BuffId, PlayerId, Improvement) VALUES";

            for (int i = 0; i < buffs.size(); i++) {
                baseSQL += " (?, ?, ?)";

                if (i < buffs.size() - 1) {
                    baseSQL += ",";
                }
            }
            baseSQL += ";";

            PreparedStatement statement = getConnection().prepareStatement(baseSQL);

            int num = 1;
            for (Buff buff : buffs) {
                statement.setInt(num, buff.getId());
                statement.setInt(num+1, playerId);
                statement.setFloat(num+2, buff.getDefaultImprovement());
                num += 3;
            }

            execute = statement.executeUpdate();

            PlayerDAO playerDAO = new PlayerDAO();
            playerDAO.updateLastUpdate(playerId);
        }catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }

    public ArrayList<PlayerBuff> getPlayerBuffByPlayerId(int playerId){
        Bukkit.getLogger().info("PlayerBuffDAO getPlayerBuffByPlayerId");
        ArrayList<PlayerBuff> playerBuffs = new ArrayList<PlayerBuff>();

        try{
            PreparedStatement statement = getConnection().prepareStatement("SELECT BuffId, PlayerId, Improvement FROM player_buff WHERE PlayerId = ?");

            statement.setInt(1, playerId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                playerBuffs.add(new PlayerBuff(result.getInt(1), result.getInt(2), result.getFloat(3)));
            }
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return playerBuffs;
    }

    public int count(int playerId) {
        Bukkit.getLogger().info("PlayerBuffDAO count");
        int execute = 0;

        try{
            PreparedStatement statement = getConnection().prepareStatement("SELECT COUNT(*) FROM player_buff WHERE PlayerId = ?");

            statement.setInt(1, playerId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                execute = result.getInt(1);
            }
            else {
                execute = -1;
                System.out.println("Count not retrieved player buffs");
            }
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }

    public int updatePlayerBuff(PlayerBuff playerBuff) {
        Bukkit.getLogger().info("PlayerBuffDAO updatePlayerBuff");
        int execute = 0;

        try{
            PreparedStatement statement = getConnection().prepareStatement("UPDATE player_buff SET Improvement = ? WHERE BuffId = ? AND PlayerId = ?");

            statement.setFloat(1, playerBuff.getImprovement());
            statement.setInt(2, playerBuff.getBuffId());
            statement.setInt(3, playerBuff.getPlayerId());

            execute = statement.executeUpdate();
        }catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }
}
