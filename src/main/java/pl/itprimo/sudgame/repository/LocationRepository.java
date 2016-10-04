package pl.itprimo.sudgame.repository;

import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;

/**
 *
 * @author Robert Kałat
 */
public class LocationRepository {

    private Location startLoc;
    
    public LocationRepository() {
        startLoc = new Location("Small room", "You're in small, dark room. Single bed standing next to the wall is only furniture in here");
        Location secondLocation = new Location("Dark corridor", "...");

        startLoc.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, startLoc);

        NPC ork = new NPC("Ork", 50, 5);

        startLoc.addNpc(ork);

    }

    public Location getStartLocation() {
        return this.startLoc;
    }

}
