package domain.gameobject.gameobjectpart;

import domain.gameobject.GameObject;

public interface GameObjectPart {

    public void destroy();

    public boolean isAlive();

    public GameObject getOwnObject();

}
