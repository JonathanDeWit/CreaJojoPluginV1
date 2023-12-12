package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.database.BaseDAO;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BuffDAO extends BaseDAO
{
    public int save(Buff buff) {
        Bukkit.getLogger().info("BuffDAO save");
        int execute = 0;

        try{
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO buff (Name, Description, defaultImprovement, maxImprovement) VALUES (?, ?, ?, ?)");

            statement.setString(1, buff.getName());
            statement.setString(2, buff.getDescription());
            statement.setFloat(3, buff.getDefaultImprovement());
            statement.setFloat(4, buff.getMaxImprovement());

            execute = statement.executeUpdate();

        }catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }

    public int count() {
        Bukkit.getLogger().info("BuffDAO count");
        int execute = 0;

        try{
            ResultSet result = getConnection().createStatement().executeQuery("SELECT COUNT(*) FROM buff");
            if (result.next()) {
                execute = result.getInt(1);
            }
            else {
                execute = -1;
                System.out.println("Count not retrieved buffs");
            }
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }

    public ArrayList<Buff> getAllBuffs(){
        Bukkit.getLogger().info("BuffDAO getAllBuffs");
        ArrayList<Buff> buffs = new ArrayList<Buff>();

        try{
            ResultSet result = getConnection().createStatement().executeQuery("SELECT Id, Name, Description, defaultImprovement, maxImprovement, addedAt FROM buff");

            while (result.next()) {
                buffs.add(new Buff(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), result.getFloat(5), result.getTimestamp(6).toLocalDateTime()));
            }
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return buffs;
    }

    public ArrayList<Buff> getRecentBuffs(LocalDateTime date){
        Bukkit.getLogger().info("BuffDAO getRecentBuffs");
        ArrayList<Buff> buffs = new ArrayList<Buff>();

        try{
            PreparedStatement statement = getConnection().prepareStatement("SELECT Id, Name, Description, defaultImprovement, maxImprovement, addedAt FROM buff WHERE addedAt >= ?");

            statement.setTimestamp(1, java.sql.Timestamp.valueOf(date));

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                buffs.add(new Buff(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), result.getFloat(5), result.getTimestamp(6).toLocalDateTime()));
            }
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return buffs;
    }
}
