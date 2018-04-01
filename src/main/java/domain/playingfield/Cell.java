package domain.playingfield;

import domain.gameobject.gameobjectpart.GameObjectPart;

public class Cell {

    private char y;
    private int x;
    private boolean labeled;
    private GameObjectPart shipPart;

    public Cell(char y, int x, GameObjectPart shipPart) {
        this.y = y;
        this.x = x;
        this.shipPart = shipPart;
        labeled = false;
    }

    public void mark() {
        labeled = true;
    }

    public GameObjectPart getGameObjectPart() {

        return shipPart;
    }

    public boolean isLabeled() {
        return labeled;
    }


    public char getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
