package be.creajojo.creajojopluginv1.Models;

public class Buff {
    private int id;
    private String BuffName;
    private String BuffDescription;
    private float improvement;

    public Buff(int id, String BuffName, String BuffDescription, float improvement) {
        this.id = id;
        this.BuffName = BuffName;
        this.BuffDescription = BuffDescription;
        this.improvement = improvement;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getBuffName() {
        return BuffName;
    }

    public String getBuffDescription() {
        return BuffDescription;
    }

    public float getImprovement() {
        return improvement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBuffName(String BuffName) {
        this.BuffName = BuffName;
    }

    public void setBuffDescription(String BuffDescription) {
        this.BuffDescription = BuffDescription;
    }

    public void setImprovement(float improvement) {
        this.improvement = improvement;
    }


}
