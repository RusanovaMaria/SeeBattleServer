package domain;

import java.util.List;

public class Ship {

    private int size;
    private Status status;

    private List<ShipUnit> shipUnitsList;

    Ship(int size) {
        this.size = size;
        fillShipUnitsList();
    }

    public int getSize() {
        return size;
    }

    public Status getStatus() {
        return status;
    }

    public List<ShipUnit> getShipUnitsList() {
        return shipUnitsList;
    }

    private void fillShipUnitsList() {
        ShipUnit shipUnit = new ShipUnit();
        int i = 0;
        while (i < size) {
            shipUnitsList.add(shipUnit);
            i++;
        }
    }
}
