public class ShipPart {

    private boolean isAlive;

    public ShipPart(){
        isAlive = true;
    }

    public void destroy(){
        isAlive = false();
    }
}
