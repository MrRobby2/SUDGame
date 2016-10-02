/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itprimo.sudgame.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Robert Kałat
 */
public class LocationTest {
    
    @Test
    public void testDescription() {
        
        Location loc = new Location("Short", "Long");
        Location loc2 = new Location("Second", "long");
        Location loc3 = new Location("Third", "long");
        loc.addExit(Direction.N, loc2);
        loc.addExit(Direction.S, loc3);
        NPC ork = new NPC("ork");
        NPC ork2 = new NPC("ork2");
        loc.addNpc(ork);
        loc.addNpc(ork2);
        String description = loc.getDescription();
        String validDescription = "Short\nLong\nVisible exits: South North \nork ork2 ";
        Assert.assertEquals("Compare description", validDescription, description);
    }
}
