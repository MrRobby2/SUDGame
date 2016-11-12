package pl.itprimo.sudgame.domain;

public class Player {

    private String name;
    private Statistic stats;
    private Location currentLocation;

    public Player(String name) {
        this.name = name;
        this.stats = new Statistic(100, 5, 10);
    }

    public Player(String name, int health, int strength) {
        this.name = name;
        this.stats = new Statistic(health, strength, 10);
    }

    public Player(String name, int health, int strength, int agility) {
        this.name = name;
        this.stats = new Statistic(health, strength, agility);
    }

    public String getName() {
        return name;
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

    public String getNearbyItem(String itemName) {
        return this.currentLocation.getItems(itemName);
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

    public boolean itThereNPCNearby(NPC targetNPC) {
        return this.currentLocation.isThereNPC(targetNPC.getName());
    }
}
