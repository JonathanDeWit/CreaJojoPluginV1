package be.creajojo.creajojopluginv1.Models;

public class PlayerBuff {
    private int BuffId;
    private int PlayerId;


    public PlayerBuff(int BuffId, int PlayerId) {
        this.BuffId = BuffId;
        this.PlayerId = PlayerId;
    }

    // Getters and setters
    public int getBuffId() {
        return BuffId;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setBuffId(int BuffId) {
        this.BuffId = BuffId;
    }

    public void setPlayerId(int PlayerId) {
        this.PlayerId = PlayerId;
    }
}
