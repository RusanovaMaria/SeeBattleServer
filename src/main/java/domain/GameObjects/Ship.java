package domain;

import java.util.List;

public class Ship implements GameObject{

    private Status status;
    private int size;
    private List<ShipPart> shipPartList;

    Ship(int size) {
        this.size = size;
        status = Status.ALIVE;
        build();
    }

    public int getSize() {

        return size;

    }

    private void build() {
        ShipPart shipPart = new ShipPart(this);
        int i = 0;
        while (i < size) {
            shipPartList.add(shipPart);
            i++;
        }
    }

    @Override
    public boolean isKilled() {
        boolean isKilled = true;

        for (ShipPart shipUnit : shipPartList) {
            if (shipUnit.getAliveStatus()) {
                isKilled = false;
            }
        }
        return isKilled;
    }

    @Override
    public boolean isAlive() {
        boolean isAlive = true;
        for (ShipPart shipUnit : shipPartList) {
            if (!shipUnit.getAliveStatus()) {
                isAlive = false;
            }
        }
        return isAlive;
    }

    @Override
    public boolean isDamaged() {
        boolean isDamaged = false;

        for (ShipPart shipUnit : shipPartList) {
            if (!isKilled() && (!isAlive())) {
                isDamaged = true;
            }
        }
        return isDamaged;
    }
}
