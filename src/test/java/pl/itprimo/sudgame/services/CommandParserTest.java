/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itprimo.sudgame.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class CommandParserTest {

    Location mainLocation;
    NPC ork;
    Player testPlayer;
    String playerCommand;
    String expect;
    String result;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
    }

    /**
     * Test of actOnCommand method, of class CommandParser.
     */
    @Test
    public void testOneParametr() {
        playerCommand = "Look";
        CommandParser cp = new CommandParser();
        expect = "CASE look";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testTwoParametrs() {
        playerCommand = "kill ork";
        CommandParser cp = new CommandParser();
        expect = "CASE kill";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testTwoWrongParametrs() {
        playerCommand = "lhjjhhj hi7uhiuh";
        CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }
    
    @Test
    public void testTwoGoodButIncompletParametrs() {
        playerCommand = "look at";
        CommandParser cp = new CommandParser();
        expect = "CASE look at without target";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }
    
     @Test
    public void testThreeParametrs() {
        playerCommand = "look at ork";
        CommandParser cp = new CommandParser();
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
        CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }
    
    @Test
    public void testOneAlmostGoodParametr() {
        playerCommand = "Look dasdasdasd";
        CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }
    
    @Test
    public void testWrongOddCommand() {
        playerCommand = "asd2 2d2d wd qd ed312d2 dasdasdasd";
        CommandParser cp = new CommandParser();
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

}
