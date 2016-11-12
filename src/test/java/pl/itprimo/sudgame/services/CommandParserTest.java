package pl.itprimo.sudgame.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandParserTest {

    Location mainLocation;
    NPC ork;
    Player testPlayer;
    String playerCommand;
    String expect;
    String result;
    CommandParser cp;
    CommandParser cpSpy;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        
//second location
        Location secondLocation = new Location("test","TEST");
        mainLocation.addExit(Direction.W, secondLocation);
        secondLocation.addExit(Direction.E, mainLocation);
        ork = new NPC("Ork", "Great horrible ORK!", 50, 5);
        secondLocation.addNpc(ork);
        secondLocation.addItems("dab", "Potezne drzewo , ktorego pien ma conajmniej trzy metry srednicy");
         
        cp = new CommandParser();
    }


    @Test
    public void testOneParametr() {
        playerCommand = "Look";
        expect = "CASE look";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testOneParametrMock() {
        playerCommand = "Look";
        cpSpy = Mockito.spy(cp);
        cpSpy.actOnCommand(playerCommand, testPlayer);
       //how??
        Mockito.verify(cpSpy, Mockito.times(1)).equals(testPlayer.getCurrentLocationDescription());
    }
    
    @Test
    public void testTwoParametrs() {
        playerCommand = "kill ork";
        //      CommandParser cp = new CommandParser();
        expect = "CASE kill";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testTwoWrongParametrs() {
        playerCommand = "lhjjhhj hi7uhiuh";
        //    CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testTwoGoodButIncompletParametrs() {
        playerCommand = "look at";
        //  CommandParser cp = new CommandParser();
        expect = "CASE look at without target";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testThreeParametrs() {
        playerCommand = "look at ork";
        //CommandParser cp = new CommandParser();
        expect = "CASE look at target";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    /*
     ODD THINGS
     */
    @Test
    public void testFourAlmostGoodParametrs() {
        playerCommand = "look at ork asdasdasd";
        //  CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testOneAlmostGoodParametr() {
        playerCommand = "Look dasdasdasd";
        //       CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testWrongOddCommand() {
        playerCommand = "asd2 2d2d wd qd ed312d2 dasdasdasd";
        //     CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

}
