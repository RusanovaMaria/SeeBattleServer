package domain.gameobject.gameobjectpart;

import domain.gameobject.GameObject;

public interface GameObjectPart {

     void destroy();

     boolean isAlive();

     GameObject getOwnObject();

}
