package domain;

public class ClassicalPlayer implements Player {
    String name;

    public ClassicalPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Result action(Cell cell) {
        Result result = Result.MISSED;

        if (cell.getUsageSatus() == true) {
            ShipPart shipPart = cell.getAllocatedPart();
            Ship ship = shipPart.getOwnerShip();

            if (ship.isKilled()) {
                result = Result.KILL;
            } else {
                result = Result.GOT;
            }
        }
        return result;
    }
}
