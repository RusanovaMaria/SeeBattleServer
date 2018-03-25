package domain;

import domain.GameObjectParts.ShipPart;

public class Cell {
    private char y;
    private int x;

    private boolean isUsed;
    private boolean isLabeled;
    private ShipPart shipPart;

    public Cell(char y, int x) {

        this.x = x;
        this.y = y;
        this.isLabeled = false;
        this.isUsed = false;
    }

    public Cell(char y, int x, ShipPart shipPart) {

        this.x = x;
        this.y = y;
        this.shipPart = shipPart;
        this.isLabeled = false;
        this.isUsed = true;
    }

    public void mark() {

        this.isLabeled = true;
    }

    public boolean getUsageSatus() {

        return isUsed;
    }

    public ShipPart getAllocatedPart() {
        return shipPart;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

}
