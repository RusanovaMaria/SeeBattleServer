package domain.GameObjectParts;

import domain.GameObjects.Ship;

public class ShipPart implements GameObjectPart {

    private Ship ship;
    private boolean isAlive;

    public ShipPart(Ship ship) {

        this.ship = ship;
        isAlive = true;
    }

    @Override
    public void destroy() {
        isAlive = false;
    }

    @Override
    public boolean getAliveStatus() {
        return isAlive;
    }

    public Ship getOwnerShip() {
        return ship;
    }
}
