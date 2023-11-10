package be.creajojo.creajojopluginv1.database.daos;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.database.BaseDAO;

import java.sql.SQLException;

public class InitDAO extends BaseDAO {

    private final String createPlayerTable = "CREATE TABLE IF NOT EXISTS player (Id INT AUTO_INCREMENT PRIMARY KEY, PlayerName VARCHAR(255) UNIQUE, PlayTime Double);";
    private final String createBuffTable = "CREATE TABLE IF NOT EXISTS buff (Id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(255), Description VARCHAR(255), defaultImprovement FLOAT, maxImprovement FLOAT, CONSTRAINT default_less_than_max CHECK (defaultImprovement <= maxImprovement));";
    private final String createPlayerBuffTable = "CREATE TABLE IF NOT EXISTS player_buff (BuffId INT, PlayerId INT, Improvement FLOAT, FOREIGN KEY (BuffId) REFERENCES buff(Id), FOREIGN KEY (PlayerId) REFERENCES player(Id));";



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
        int execute = 0;

        System.out.println("Start populate database");
        try{
            // Populate the buff table
            BuffDAO buffDAO = new BuffDAO();
            System.out.println("count: "+ buffDAO.count());
            if (buffDAO.count() == 0){
                execute = populateBuffTable(buffDAO);
            }


        }catch (Exception e)
        {
            System.out.println("Populate Error: " + e.getMessage());
            execute = -1;
        }
        return execute;
    }


    public int TableInit(String createStatement){
        int execute = 0;
        try {
            execute = getConnection().createStatement().executeUpdate(createStatement);

        } catch (SQLException e) {
            System.out.println("Table Init Error"+e.getMessage());
        }

        return execute;
    }

    // Populate the buff table with the default buffs
    private int populateBuffTable(BuffDAO buffDAO){
        int execute = -1;
        // Speed
        Buff speed = new Buff("Speed", "Increases the speed of the player. Value need to be between 0 and 2", 0f, 2.0f);
        execute = buffDAO.save(speed);

        // Jump_boost
        Buff jumpBoost = new Buff("Jump_Boost", "Increases the jump height of the player. Value can be 0 or 1.", 0f, 1.0f);
        execute = buffDAO.save(jumpBoost);

        // Strength
        Buff strength = new Buff("Strength", "Increases the strength of the player", 0f, 1.0f);
        execute = buffDAO.save(strength);

        // Regeneration
        Buff regeneration = new Buff("Regeneration", "Increases the regeneration of the player", 0f, 1.0f);
        execute = buffDAO.save(regeneration);

        // Fire_Resistance
        Buff fireResistance = new Buff("Fire_Resistance", "Makes the player immune to fire", 0f, 1.0f);
        execute = buffDAO.save(fireResistance);

        return execute;
    }



}
