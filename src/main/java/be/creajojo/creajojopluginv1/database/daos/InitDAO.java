package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.database.BaseDAO;

import java.sql.SQLException;

public class InitDAO extends BaseDAO {

    private final String createPlayerTable = "CREATE TABLE IF NOT EXISTS player (Id INT PRIMARY KEY, PlayerName VARCHAR(255), PlayerTime Double);";
    private final String createBuffTable = "CREATE TABLE IF NOT EXISTS buff (Id INT PRIMARY KEY, BuffName VARCHAR(255), Improvement FLOAT);";
    private final String createPlayerBuffTable = "CREATE TABLE IF NOT EXISTS player_buff (BuffId INT, PlayerId INT, FOREIGN KEY (BuffId) REFERENCES buff(Id), FOREIGN KEY (PlayerId) REFERENCES player(Id));";



    public int InitDataBase(){
        int execute = 0;
        System.out.println("Start database init");
        try{
            // Try creating table player
            execute = TableInit(createPlayerTable);
            System.out.println("Table player created "+execute);

            // Try creating table buff
            execute = TableInit(createBuffTable);
            System.out.println("Table buff created "+execute);

            // Try creating table player_buff
            execute = TableInit(createPlayerBuffTable);
            System.out.println("Table player buff created "+execute);


            getConnection().close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return execute;
    }

    public int populateDataBase(){

        return 0;
    }


    public int TableInit(String createStatement){
        int execute = 0;
        try {
            execute = getConnection().createStatement().executeUpdate(createStatement);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return execute;
    }



}
