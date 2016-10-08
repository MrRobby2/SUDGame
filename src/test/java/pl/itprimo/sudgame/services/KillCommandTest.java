package pl.itprimo.sudgame.services;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
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
        ork = new NPC("ork");
        mainLocation.addNpc(ork);
    }
    
    @Test
    public void testKill(){
        Player testPlayer = new Player("Robert");
        testPlayer.setCurrentLocation(mainLocation);
        KillCommand kill = new KillCommand("ork", testPlayer);
        KillCommand killSpy = Mockito.spy(kill);
        killSpy.execute();
        Mockito.verify(killSpy, times(1)).beginCombat(testPlayer, ork);        
    }
}
