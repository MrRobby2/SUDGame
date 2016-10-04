package pl.itprimo.sudgame.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class CommandParserTest {

    Location mainLocation;
    Location northLocation;
    Player dummyPlayer;
    CommandParser parser;
    CommandParser spyParser;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "long");
        mainLocation.addExit(Direction.N, northLocation);
        dummyPlayer = new Player("Zenek");
        NPC ork = new NPC("ork");
        mainLocation.addNpc(ork);
        parser = new CommandParser();
        spyParser = Mockito.spy(parser);
        dummyPlayer.setCurrentLocation(mainLocation);
    }

    @Test
    public void testParserMove() {
        spyParser.actOnCommand("north", dummyPlayer);
        Mockito.verify(spyParser, times(1)).move(Direction.N, dummyPlayer);
    }

    @Test
    public void testParserKill() {
        spyParser.actOnCommand("kill ork", dummyPlayer);
        Mockito.verify(spyParser, times(1)).attack("ork", dummyPlayer);
    }
}
