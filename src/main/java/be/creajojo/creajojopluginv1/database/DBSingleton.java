package be.creajojo.creajojopluginv1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {

    private static DBSingleton instance = null;
    private Connection connection;


    // Credentials
    // Database
    private final String url = "jdbc:mysql://localhost/minecraft";
    private final String user = "...";
    private final String pass = "...";

    private DBSingleton() {

    }

    public static DBSingleton getInstance() {
        if (instance == null) {
            instance = new DBSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        try{
            connection = DriverManager.getConnection(url, user, pass);

            System.out.println("Connected to database");

        }catch (SQLException e){
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }

        return connection;
    }


}
