package pl.itprimo.sudgame.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class LookCommandTest {

    Location mainLocation;
    NPC ork;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");

    }

    @Test
    public void returnDescription() {
        Player testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        LookCommand look = new LookCommand(testPlayer);
        String result = look.execute();
        Assert.assertEquals("Short\nLong\nVisible exits: \n", result);

    }

    @Test
    public void returnDescriptionNpcOnLocation() {
        Player testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        ork = new NPC("TestOrk", "Great horrible ork");
        mainLocation.addNpc(ork);
        LookCommand look = new LookCommand("TestOrk", testPlayer);
        String result = look.execute();
        Assert.assertEquals("Great horrible ork", result);

    }
   
    @Test
    public void returnDescriptionItemOnLocation() {
        Player testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        mainLocation.addItems("dab", "szerszy opis drzewa");
        LookCommand look = new LookCommand("dab",testPlayer);
        String result = look.execute();
        Assert.assertEquals("szerszy opis drzewa", result);

    }
    
    @Test
    public void returnDescriptionWhenNameOfItemAndNpcAreIdentical() {
        Player testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        ork = new NPC("222", "Great horrible ork");
        mainLocation.addNpc(ork);
        mainLocation.addItems("222", "szerszy opis drzewa");
        LookCommand look = new LookCommand("222",testPlayer);
        String result = look.execute();
        Assert.assertEquals("NPC: Great horrible ork\nItem: szerszy opis drzewa", result);

    }
    
}
