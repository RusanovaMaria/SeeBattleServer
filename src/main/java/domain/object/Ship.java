package domain.object;

import domain.object.unit.ShipUnit;
import domain.Status;

import java.util.List;

public class Ship {

    private int size;
    private Status status;

    private List<ShipUnit> shipPartList;

    public int getSize() {
        return size;
    }

    public Status getStatus() {
        return status;
    }

    public List<ShipUnit> getShipPartList() {
        return shipPartList;
    }

}
