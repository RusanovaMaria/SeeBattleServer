package domain.gameobject.gameobjectpart;

import domain.gameobject.GameObject;
import domain.gameobject.Ship;

public class ShipPart implements GameObjectPart {

    private boolean lifeStatus;
    private GameObject ship;

    public ShipPart(GameObject ship) {
        this.ship = ship;
        lifeStatus = true;
    }

    @Override
    public void destroy() {
        lifeStatus = false;
    }

    @Override
    public boolean isAlive() {
        return lifeStatus;
    }

    @Override
    public GameObject getOwnObject() {
        return ship;
    }
}
