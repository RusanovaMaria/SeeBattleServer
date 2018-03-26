package domain.playingfield;

public class Cell {

    char y;
    int x;
    boolean isLabeled;

    public Cell(char y, int x) {
        this.y = y;
        this.x = x;
        isLabeled = false;
    }

    public void mark() {
        isLabeled = true;
    }
}
