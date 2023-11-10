package be.creajojo.creajojopluginv1.Models;

public class Buff {
    private int id;
    private String Name;
    private String Description;
    private float defaultImprovement;

    private float maxImprovement;


    public Buff(int id, String BuffName, String BuffDescription, float defaultImprovement, float maxImprovement) {
        this.id = id;
        this.Name = BuffName;
        this.Description = BuffDescription;
        this.defaultImprovement = defaultImprovement;
        this.maxImprovement = maxImprovement;
    }

    public Buff(String BuffName, String BuffDescription, float defaultImprovement, float maxImprovement) {
        this.Name = BuffName;
        this.Description = BuffDescription;
        this.defaultImprovement = defaultImprovement;
        this.maxImprovement = maxImprovement;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public float getDefaultImprovement() {
        return defaultImprovement;
    }

    public float getMaxImprovement() {
        return maxImprovement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String BuffName) {
        this.Name = BuffName;
    }

    public void setDescription(String BuffDescription) {
        this.Description = BuffDescription;
    }

    public void setDefaultImprovement(float defaultImprovement) {
        this.defaultImprovement = defaultImprovement;
    }

    public void setMaxImprovement(float maxImprovement) {
        this.maxImprovement = maxImprovement;
    }


}
