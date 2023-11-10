package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.database.BaseDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuffDAO extends BaseDAO implements DAOEntity<Buff>
{
    @Override
    public int save(Buff buff) {
        int execute = 0;

        try{
            // protect against sql injection
            String baseString = "INSERT INTO Buff ";

            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO Buff (Name, Description, defaultImprovement, maxImprovement) VALUES (?, ?, ?, ?)");

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

    @Override
    public int count() {
        int execute = 0;

        //SELECT COUNT(*) FROM buff;
        //Without PreparedStatement
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
}
