package be.creajojo.creajojopluginv1.Models;

import org.bukkit.Statistic;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomPlayer {
    private int id;
    private String Name;
    private double PlayTime;
    private LocalDate FirstJoin;
    private LocalDateTime LastUpdate;

    public CustomPlayer(int id, String Name, Double PlayTime) {
        this.id = id;
        this.Name = Name;
        this.PlayTime = PlayTime;
        this.FirstJoin = LocalDate.now();
        this.LastUpdate = LocalDateTime.now();
    }

    public CustomPlayer(int id, String Name, Double PlayTime, LocalDate FirstJoin, LocalDateTime LastUpdate) {
        this.id = id;
        this.Name = Name;
        this.PlayTime = PlayTime;
        this.FirstJoin = FirstJoin;
        this.LastUpdate = LastUpdate;
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

    public LocalDate getFirstJoin() {
        return FirstJoin;
    }

    public LocalDateTime getLastUpdate() {
        return LastUpdate;
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

    public void setFirstJoin(LocalDate FirstJoin) {
        this.FirstJoin = FirstJoin;
    }

    public void setLastUpdate(LocalDateTime LastUpdate) {
        this.LastUpdate = LastUpdate;
    }

    public static CustomPlayer fromMinecraftPlayer(org.bukkit.entity.Player player) {
        return new CustomPlayer(0, player.getName(), (double) player.getStatistic(Statistic.PLAY_ONE_MINUTE));
    }

    @Override
    public String toString() {
        return "CustomPlayer{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", PlayTime=" + PlayTime +
                ", FirstJoin=" + FirstJoin +
                ", LastUpdate=" + LastUpdate +
                '}';
    }
}
