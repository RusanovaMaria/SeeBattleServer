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

    public boolean isDamaded() {
        boolean damaged = false;

        for (ShipUnit shipUnit : shipUnitsList) {
            if (!isKilled() && (!isNotDamaged())){
                damaged = true;
            }
        }
    }

    public boolean isKilled() {
        boolean isKilled = true;

        for (ShipUnit shipUnit : shipUnitsList) {
            if (shipUnit.getAliveStatus()) {
                isKilled = false;
            }
        }
        return isKilled;
    }

    public boolean isNotDamaged() {
        boolean notDamaged = true;
        for (ShipUnit shipUnit : shipUnitsList) {
            if (!shipUnit.getAliveStatus()) {
                notDamaged = false;
            }
        }
        return notDamaged;
    }
}
