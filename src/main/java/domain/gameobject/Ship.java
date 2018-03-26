package domain.gameobject;

import domain.playingfield.Cell;

import java.util.ArrayList;

public class Ship implements GameObject {

    private ArrayList<Cell> cells;
    int size;
    private Status status;

    public Ship(int size, Status status) {

        this.size = size;
        this.status = status;
        status = Status.ALIVE;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void changeStatus() {

    }
}
