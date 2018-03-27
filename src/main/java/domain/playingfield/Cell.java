package domain.playingfield;

import domain.gameobject.gameobjectpart.ShipPart;

public class Cell {

    private char y;
    private int x;
    private boolean isLabeled;
    private ShipPart shipPart;


    public Cell(char y, int x, ShipPart shipPart) {
        this.y = y;
        this.x = x;
        this.shipPart = shipPart;
        isLabeled = false;
    }

    public void mark() {
        isLabeled = true;
    }

    public ShipPart getShipPart() {
        return shipPart;
    }
}
