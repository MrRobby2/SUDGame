package pl.itprimo.sudgame.domain;

public class NPC {

    private String name;
    private Statistic stats;
    private String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
        this.stats = new Statistic(100, 5, 10);
    }

    public NPC(String name, String description, int health, int strength) {
        this.name = name;
        this.description = description;
        this.stats = new Statistic(health, strength, 10);
    }

    public NPC(String name, String description, int health, int strength, int agility) {
        this.name = name;
        this.description = description;
        this.stats = new Statistic(health, strength, agility);
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return this.stats.getHealth() > 0;
    }

    public int getStrength() {
        return this.stats.getStrength();
    }

    public void damageTaken(int hit) {
        this.stats.setHealth(this.stats.getHealth() - hit);
    }

    public int getAgility() {
        return this.stats.getAgility();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
