package pl.kalat.sudgame.domain;

import pl.kalat.sudgame.domain.Direction;
import pl.kalat.sudgame.domain.Location;
import pl.kalat.sudgame.domain.NPC;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "long");
        Location southLocation = new Location("Third", "long");
        mainLocation.addExit(Direction.N, northLocation);
        mainLocation.addExit(Direction.S, southLocation);
        NPC ork = new NPC("ork","Great horrible ork");
        NPC secondOrk = new NPC("ork2","Great horrible ork");
        mainLocation.addNpc(ork);
        mainLocation.addNpc(secondOrk);
    }

    @Test
    public void testDescription() {

        String description = mainLocation.getDescription();
        String validDescription = "Short\nLong\nVisible exits: North, South\nork, ork2";
        Assert.assertEquals("Compare description", validDescription, description);
    }

    @Test
    public void testGetNextLocation() {

        Location nextLoc = mainLocation.getNextLocation(Direction.N);
        Assert.assertEquals("Same object", northLocation, nextLoc);

        Location nullLoc = mainLocation .getNextLocation(Direction.E);
        Assert.assertNull("Non-existing location", nullLoc);
    }

    @Test
    public void testGetNPC() {
        NPC getOrk = mainLocation.getNPC("ork");
        Assert.assertEquals("Existing npc", "ork", getOrk.getName());
        NPC getOrk2 = mainLocation.getNPC("ork3");
        Assert.assertNull("Non-existing npc", getOrk2);
    }
}