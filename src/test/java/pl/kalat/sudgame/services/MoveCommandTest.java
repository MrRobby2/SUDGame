package pl.kalat.sudgame.services;

import pl.kalat.sudgame.services.MoveCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.kalat.sudgame.domain.Direction;
import pl.kalat.sudgame.domain.Location;
import pl.kalat.sudgame.domain.NPC;
import pl.kalat.sudgame.domain.Player;

public class MoveCommandTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "long");
        mainLocation.addExit(Direction.N, northLocation);
        NPC ork = new NPC("ork","Great horrible ork");
        mainLocation.addNpc(ork);
    }

    @Test
    public void moveIfProperDirectionIsSend() {
        Player p = new Player("Test player");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.N, p);
        String result = move.execute();
        Assert.assertEquals(northLocation.getDescription(), result);
    }

    @Test
    public void returnInfoIfThereIsNoLocationInGivenDirection(){
        Player p = new Player("Test player");
        p.setCurrentLocation(mainLocation);
        MoveCommand move = new MoveCommand(Direction.E, p);
        String result = move.execute();
        Assert.assertEquals("you can't go that way", result);
    }
}
