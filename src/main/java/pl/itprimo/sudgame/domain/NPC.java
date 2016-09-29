package pl.itprimo.sudgame.domain;

/**
 *
 * @author Robert Kałat
 */
public class NPC {

    private String name;
    private int health;
    private int strength;

    public NPC(String name) {
        this.name = name;
    }

    public NPC(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    
    public String getName() {
        return name;
    }

}
