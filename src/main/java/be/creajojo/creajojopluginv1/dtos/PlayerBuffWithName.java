package be.creajojo.creajojopluginv1.dtos;

import be.creajojo.creajojopluginv1.Models.Buff;
import be.creajojo.creajojopluginv1.Models.CustomPlayer;
import be.creajojo.creajojopluginv1.Models.PlayerBuff;

public class PlayerBuffWithName {
    private int BuffId;
    private String BuffName;
    private int PlayerId;
    private String PlayerName;
    private float defaultImprovement;
    private float maxImprovement;
    private float Improvement;


    public PlayerBuffWithName(Buff buff, CustomPlayer player, PlayerBuff playerBuff){
        this.BuffId = buff.getId();
        this.BuffName = buff.getName();
        this.defaultImprovement = buff.getDefaultImprovement();
        this.maxImprovement = buff.getMaxImprovement();
        this.PlayerId = player.getId();
        this.PlayerName = player.getName();
        this.Improvement = playerBuff.getImprovement();
    }

}
