package be.creajojo.creajojopluginv1.dtos;

import be.creajojo.creajojopluginv1.Models.CustomPlayer;
import be.creajojo.creajojopluginv1.Models.PlayerBuff;

import java.util.ArrayList;

public class PlayerWithBuffs {

    private CustomPlayer player;
    private ArrayList<PlayerBuff> playerBuffs;

    public PlayerWithBuffs(CustomPlayer player, ArrayList<PlayerBuff> playerBuffs) {
        this.player = player;
        this.playerBuffs = playerBuffs;
    }

    public CustomPlayer getPlayer() {
        return player;
    }

    public ArrayList<PlayerBuff> getPlayerBuffs() {
        return playerBuffs;
    }

    public void setPlayer(CustomPlayer player) {
        this.player = player;
    }

    public void setPlayerBuffs(ArrayList<PlayerBuff> playerBuffs) {
        this.playerBuffs = playerBuffs;
    }
}
