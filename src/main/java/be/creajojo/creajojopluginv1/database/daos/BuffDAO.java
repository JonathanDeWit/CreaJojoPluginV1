package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.database.BaseDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuffDAO extends BaseDAO implements DAOEntity<Buff>
{
    @Override
    public int save(Buff buff) {
        int execute = 0;

        try{
            // protect against sql injection
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO Buff (Name, Description, defaultImprovement) VALUES (?, ?, ?)");

            statement.setString(1, buff.getName());
            statement.setString(2, buff.getDescription());
            statement.setFloat(3, buff.getDefaultImprovement());

            execute = statement.executeUpdate();

        }catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return execute;
    }
}
