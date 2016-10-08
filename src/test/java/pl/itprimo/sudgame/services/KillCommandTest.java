package pl.itprimo.sudgame.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

public class KillCommandTest {

    Location mainLocation;
    NPC ork;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        ork = new NPC("ork","Great horrible ork");
        mainLocation.addNpc(ork);
    }

    @Test
    public void beginCombatIfTargetIsThere() {
        Player testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("ork", testPlayer);
        KillCommand killSpy = Mockito.spy(kill);
        killSpy.execute();
        Mockito.verify(killSpy, times(1)).beginCombat(testPlayer, ork);
    }

    @Test
    public void returnTargetNotThereInfoIfTargetIsNoOnLocation() {
        Player testPlayer = new Player("Test player");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("goblin", testPlayer);
        String result = kill.execute();
        Assert.assertEquals("There's no one like that around.", result);
        
    }
}
