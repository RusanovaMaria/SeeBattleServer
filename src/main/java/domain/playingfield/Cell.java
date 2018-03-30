package domain.playingfield;

import domain.gameobject.gameobjectpart.GameObjectPart;

public class Cell {

    private char y;
    private int x;
    private boolean labeled;
    private boolean used;
    private GameObjectPart shipPart;

    public Cell (char y, int x){
        this.y = y;
        this.x = x;
        labeled = false;
        used = false;
    }

    public Cell(char y, int x, GameObjectPart shipPart) {
        this.y = y;
        this.x = x;
        this.shipPart = shipPart;
        labeled = false;
        used = true;
    }

    public void mark() {
        labeled = true;
    }

    public GameObjectPart getGameObjectPart() {
        return shipPart;
    }

    public boolean isLabeled(){
        return labeled;
    }

    public boolean isUsed(){
        return used;
    }
}
