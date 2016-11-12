package pl.itprimo.sudgame.repository;

import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;

public class LocationRepository {

    private Location startLoc;

    public LocationRepository() {
        startLoc = new Location("Small room", "You're in small, dark room. Single bed standing next to the wall is only furniture in here");
        
        Location secondLocation = new Location("Dark corridor", "...");
        startLoc.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, startLoc);

        Location thirdLocation = new Location("test","TEST");
        startLoc.addExit(Direction.W, thirdLocation);
        thirdLocation.addExit(Direction.E, startLoc);
        
        NPC ork = new NPC("Ork", "Great horrible ORK!", 50, 5);

        startLoc.addNpc(ork);
        startLoc.addItems("dab", "Potezne drzewo , ktorego pien ma conajmniej trzy metry srednicy");
    }

    public Location getStartLocation() {
        return this.startLoc;
    }

}
