package pl.itprimo.sudgame.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    Location mainLocation;
    Location northLocation;

    @Before
    public void initTest() {
        mainLocation = new Location("Short", "Long");
        northLocation = new Location("Second", "long");
        mainLocation.addExit(Direction.N, northLocation);
    }   
}