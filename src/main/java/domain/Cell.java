package domain;

public class Cell {
    private int x;
    private int y;

    private boolean isUsed;
    private boolean isLabeled;
    private ShipUnit shipUnit;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isLabeled = false;
        this.isUsed = false;
    }

    public Cell(int x, int y, ShipUnit shipUnit){
        this.x = x;
        this.y = y;
        this.shipUnit = shipUnit;
        this.isLabeled = false;
        this.isUsed = true;
    }

    public void mark() {
        this.isLabeled = true;
    }

    public boolean getUsageSatus(){
        return isUsed;
    }
}
