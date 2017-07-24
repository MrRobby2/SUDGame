package pl.kalat.sudgame.domain;

public class Statistic {

    private int health;
    private int strength;
    private int agility;

    public Statistic(int health, int strength, int agility) {
        this.health = health;
        this.strength = strength;
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    
    
    
    
}
