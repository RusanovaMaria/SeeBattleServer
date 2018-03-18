package domain.game;

import domain.Cell;
import domain.GameField;
import domain.Gamer;
import domain.Result;

public interface Game {

    Result shoot(Gamer gamer, Cell cell);

    GameField getGameField(Gamer gamer);

    boolean checkEnd();

    Gamer getWinner();

}
