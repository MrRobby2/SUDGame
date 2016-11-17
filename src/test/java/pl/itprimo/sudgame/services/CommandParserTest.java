package pl.itprimo.sudgame.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Robert Kałat
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandParserTest {

    private Player testPlayer;
    private String playerCommand;
    private String expect;
    private String result;
    private CommandParser cp;

    @Before
    public void initTest() {
        Location mainLocation = new Location("Short", "Long");
        testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);

        //second location
        Location secondLocation = new Location("test", "TEST");
        mainLocation.addExit(Direction.W, secondLocation);
        secondLocation.addExit(Direction.E, mainLocation);
        NPC ork = new NPC("Ork", "Great horrible ORK!", 50, 5);
        secondLocation.addNpc(ork);
        secondLocation.addItems("dab", "Potezne drzewo , ktorego pien ma conajmniej trzy metry srednicy");

        cp = new CommandParser();
    }

    @Test
    public void actOnCommandOneParameterTest() {
        //for
        playerCommand = "Look";
        expect = "CASE look";

        //when
        result = cp.actOnCommand(playerCommand, testPlayer);

        //then
        assertThat("Preseted data for LOOK command: ", expect, is(result));
    }

    @Test
    public void commandParserActOnCommandVerifyTest() {
        //for
        playerCommand = "Look";
        CommandParser cp = this.cp;

        //when
        cp.actOnCommand(playerCommand, testPlayer);

        //then
        verify(cp, Mockito.times(1)).actOnCommand(playerCommand, testPlayer);
    }

    @Test
    public void commandParserActOnCommandSpyTest() {
        //for
        playerCommand = "Look";
        Player spyPlayer = spy(testPlayer);


        //when
        cp.actOnCommand(playerCommand, spyPlayer);

        //then
        when(spyPlayer).thenReturn(testPlayer);
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
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testTwoGoodButIncompletParametrs() {
        playerCommand = "look at";
        expect = "CASE look at without target";
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testThreeParametrs() {
        playerCommand = "look at ork";
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
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testOneAlmostGoodParametr() {
        playerCommand = "Look dasdasdasd";
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void testWrongOddCommand() {
        playerCommand = "asd2 2d2d wd qd ed312d2 dasdasdasd";
        expect = null;
        result = cp.actOnCommand(playerCommand, testPlayer);
        Assert.assertEquals(expect, result);
    }

}
