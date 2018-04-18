package domain.cage;

import domain.GameObjectPart;

public class Cage {

    private boolean used;
    private char y;
    private int x;
    private GameObjectPart gameObjectPart;

    public Cage(int x, char y, GameObjectPart gameObjectPart) {

        this.y = y;
        this.x = x;
        this.gameObjectPart = gameObjectPart;
        used = false;
    }

    public void markAsUsed() {
        used = true;
    }

    public boolean wasUsed() {

        if (used == true) {
            return true;
        }

        return false;
    }
}
