package domain.gameobject;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {

    @org.junit.Test
    public void changeStatus() {
        Ship ship = new Ship(3);
        ship.changeStatus();
        Status status = ship.getStatus();
        assertEquals(Status.ALIVE, status);
    }
}