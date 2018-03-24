package domain;

public class ShipPart implements GameObjectPart{

    private Ship ship;
    private boolean isAlive;

    ShipPart(Ship ship){

        this.ship = ship;
        isAlive = true;
    }

    @Override
    public void destroy(){
        isAlive = false;
    }

    @Override
    public boolean getAliveStatus(){
        return isAlive;
    }

    public Ship getOwnerShip(){
        return ship;
    }
}
