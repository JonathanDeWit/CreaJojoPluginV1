package be.creajojo.creajojopluginv1.Models;

public class PlayerBuff {
    private int BuffId;
    private int PlayerId;
    private float Improvement;

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

    public float getImprovement() {
        return Improvement;
    }

    public void setBuffId(int BuffId) {
        this.BuffId = BuffId;
    }

    public void setPlayerId(int PlayerId) {
        this.PlayerId = PlayerId;
    }

    public void setImprovement(float Improvement) {
        this.Improvement = Improvement;
    }
}
