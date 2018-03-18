package domain.object.unit;

public class ShipUnit {

    private boolean isAlive;

    public ShipUnit() {
        isAlive = true;
    }

    public void destroy() {
        isAlive = false;
    }

}
