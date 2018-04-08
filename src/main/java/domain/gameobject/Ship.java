package domain.gameobject;

import domain.gameobject.gameobjectpart.GameObjectPart;
import domain.gameobject.gameobjectpart.ShipPart;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Ship implements GameObject {

    private ArrayList<GameObjectPart> shipParts;
    int size;
    private Status status;
    private Kind kind;

    public Ship(int size) {

        this.size = size;
        build(size);
        defineVariety(size);
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
    public Kind getKind() {
        return kind;
    }

    @Override
    public void changeStatus() {

        if (isDamaged()) status = Status.INJURED;
        if (isKilled()) status = Status.KILLED;
    }

    @Override
    public ArrayList<GameObjectPart> getAllParts() {
        return shipParts;
    }

    private void build(int size) {
        shipParts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            shipParts.add(new ShipPart(this));
        }
    }

    private void defineVariety(int size) {
        if (size == 1) kind = Kind.SINGLE_DECKED;
        if (size == 2) kind = Kind.DOUBLE_DECKED;
        if (size == 3) kind = Kind.THREE_DECKED;
        if (size == 4) kind = Kind.FOUR_DECKED;
    }

    private boolean isDamaged() {
        boolean damage = false;

        if ((!isKilled()) && (!isAlive())) {
            damage = true;
        }
        return damage;
    }

    private boolean isAlive() {

        boolean alive = true;

        for (int i = 0; i < shipParts.size(); i++) {
            GameObjectPart shipPart = shipParts.get(i);
            if (!shipPart.isAlive()) {
                alive = false;
            }
        }
        return alive;
    }

    private boolean isKilled() {
        boolean kill = true;

        for (int i = 0; i < shipParts.size(); i++) {
            GameObjectPart shipPart = shipParts.get(i);
            if (shipPart.isAlive()) {
                kill = false;
            }
        }
        return kill;
    }
}
