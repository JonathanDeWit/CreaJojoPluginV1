package be.creajojo.creajojopluginv1.services;


import be.creajojo.creajojopluginv1.dtos.PlayerBuffWithName;

import java.util.ArrayList;
import java.util.List;

// Singleton
public class PlayerInfoService {
    private static PlayerInfoService instance = null;

    // CustomPlayer
    private ArrayList<PlayerBuffWithName> updatedPlayerBuffs;

    private PlayerInfoService() {
    }

    public static PlayerInfoService getInstance() {
        if (instance == null) {
            instance = new PlayerInfoService();
        }
        return instance;
    }


    private void updatePlayersBuffs() {

    }

    // Getters
    public List<PlayerBuffWithName> getUpdatedPlayerBuffs() {
        if (updatedPlayerBuffs == null) {
            updatePlayersBuffs();
        }
        return updatedPlayerBuffs;
    }

    // Setters
    public void setUpdatedPlayerBuffs(ArrayList<PlayerBuffWithName> updatedPlayerBuffs) {
        this.updatedPlayerBuffs = updatedPlayerBuffs;
    }


}
