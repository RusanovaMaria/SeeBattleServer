package domain;

import domain.object.unit.ShipUnit;

public class Cell {

    private int x;
    private char y;

    private ShipUnit shipUnit;

    private boolean isLabeled;

    public Cell(int x, char y, ShipUnit shipUnit) {
        this.x = x;
        this.y = y;
        this.shipUnit = shipUnit;
        this.isLabeled = false;
    }

    public void mark() {
        this.isLabeled = true;
    }

}
