package domain.Game.Player;

import domain.Cell;
import domain.Enums.Result;

public interface Player {
    String getName();

    Result action(Cell cell);
}
