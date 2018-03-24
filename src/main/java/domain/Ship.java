package domain;

import java.util.List;

public class Ship{

    private Status status;
    private int size;
    private List<ShipPart> shipPartList;

    Ship(int size) {
        this.size = size;
        build();
    }

    public int getSize() {

        return size;
    }

    public List<ShipPart> getUnitsList() {

        return shipPartList;
    }

    private void build() {
        ShipPart shipPart = new ShipPart(this);
        int i = 0;
        while (i < size) {
            shipPartList.add(shipPart);
            i++;
        }
    }

    public boolean isDamaded() {
        boolean damaged = false;

        for (ShipPart shipUnit : shipPartList) {
            if (!isKilled() && (!isNotDamaged())) {
                damaged = true;
            }
        }
        return damaged;
    }

    public boolean isKilled() {
        boolean isKilled = true;

        for (ShipPart shipUnit : shipPartList) {
            if (shipUnit.getAliveStatus()) {
                isKilled = false;
            }
        }
        return isKilled;
    }

    public boolean isNotDamaged() {
        boolean notDamaged = true;
        for (ShipPart shipUnit : shipPartList) {
            if (!shipUnit.getAliveStatus()) {
                notDamaged = false;
            }
        }
        return notDamaged;
    }
}
