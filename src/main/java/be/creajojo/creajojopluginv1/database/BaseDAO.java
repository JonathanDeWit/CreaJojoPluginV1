package be.creajojo.creajojopluginv1.database;

import java.sql.Connection;

public class BaseDAO {

    Connection connection;

    public BaseDAO() {

    }

    public Connection getConnection() {
        try{
            if (connection == null || connection.isClosed()) {
                connection = DBSingleton.getInstance().getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
