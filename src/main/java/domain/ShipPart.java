package domain;

public class ShipPart {

    private Ship ship;
    private boolean isAlive;

    ShipPart(Ship ship){

        this.ship = ship;
        isAlive = true;
    }

    public void destroy(){
        isAlive = false;
    }

    public Ship getOwnerShip(){
        return ship;
    }

    public boolean getAliveStatus(){
        return isAlive;
    }
}
