package pl.itprimo.sudgame.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

public class MoveCommandTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "long");
        mainLocation.addExit(Direction.N, northLocation);
        NPC ork = new NPC("ork");
        mainLocation.addNpc(ork);
    }

    @Test
    public void testMova() {
        Player p = new Player("Robert");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.N, p);
        move.execute();
        Assert.assertEquals("Move to other location", northLocation, p.getCurrentLocation());
    }

}
