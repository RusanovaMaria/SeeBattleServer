package domain;

public class ShipUnit {

    private boolean isAlive;

    ShipUnit(){
        isAlive = true;
    }

    public void destroy(){
        isAlive = false;
    }

    public boolean getAliveStatus(){
        return isAlive;
    }
}
