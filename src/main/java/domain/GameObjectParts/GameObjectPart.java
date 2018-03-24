package domain.GameObjectParts;

import domain.GameObjects.Ship;

public interface GameObjectPart {

    void destroy();

    boolean getAliveStatus();

    Ship getOwnerShip();
}
