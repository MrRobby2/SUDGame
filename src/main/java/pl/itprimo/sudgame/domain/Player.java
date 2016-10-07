package pl.itprimo.sudgame.domain;

public class Player {

    private String name;
    private Location currentLocation;

    private int health;
    private int strength;
    private int agility;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.strength = 5;
        this.agility = 10;
    }

    public Player(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = 10;
    }

    public Player(String name, int health, int strength, int agility) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
    }
    
    public String getName() {
        return name;
    }

    public int getAgility() {
        return agility;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public String getCurrentLocationDescription() {
        return this.currentLocation.getDescription();
    }

    public boolean move(Direction direction) {
        Location nextLocation = this.currentLocation.getNextLocation(direction);
        if (nextLocation != null) {
            this.currentLocation = nextLocation;
            return true;
        } else {
            return false;
        }
    }

    public NPC getNearbyNPC(String npcName) {
        return this.currentLocation.getNPC(npcName);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getStrength() {
        return strength;
    }

    public void damageTaken(int hit) {
        this.health = this.health - hit;
    }

    public boolean itThereNPCNearby(NPC targetNPC) {
    return this.currentLocation.isThereNPC(targetNPC.getName());
    }

}
