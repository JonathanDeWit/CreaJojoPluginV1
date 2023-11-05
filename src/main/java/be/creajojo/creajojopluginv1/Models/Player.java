package be.creajojo.creajojopluginv1.Models;

import java.math.BigInteger;

public class Player {
    private int id;
    private String Name;
    private double PlayTime;

    public Player(int id, String Name, Double PlayTime) {
        this.id = id;
        this.Name = Name;
        this.PlayTime = PlayTime;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Double getPlayTime() {
        return PlayTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPlayTime(Double PlayTime) {
        this.PlayTime = PlayTime;
    }
}
