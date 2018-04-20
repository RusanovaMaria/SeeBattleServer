package domain.GameObjectPart;

import domain.GameObject.GameObject;

public class ShipPart implements GameObjectPart {

    private GameObject gameObject;
    private boolean alive;

    public ShipPart(GameObject gameObject) {

        this.gameObject = gameObject;
        alive = true;
    }

    @Override
    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void kill() {
        alive = false;
    }
}
