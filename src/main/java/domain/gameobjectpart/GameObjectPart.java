package domain.GameObjectPart;

import domain.GameObject.GameObject;

public interface GameObjectPart {

    GameObject getGameObject();

    boolean isAlive();

    void kill();
}
