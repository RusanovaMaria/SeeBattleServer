package domain.Game.Player;

import domain.Cell;
import domain.Enums.Result;
import domain.GameObjects.Ship;
import domain.GameObjectParts.ShipPart;

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
            } else if (ship.isAlive()) {
                result = Result.GOT;
            }
        }
        return result;
    }
}
