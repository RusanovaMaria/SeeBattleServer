package domain.game;

import domain.Cell;
import domain.GameField;
import domain.Gamer;
import domain.Result;

import java.util.HashMap;
import java.util.Map;

public class ClassicalGame implements Game {

    private Gamer firstGamer;
    private Gamer secondGamer;

    private Map<Gamer, GameField> gameFields;

    public ClassicalGame(Gamer firstGamer, Gamer secondGamer) {
        this.firstGamer = firstGamer;
        this.secondGamer = secondGamer;
        initGameFields();
    }

    private void initGameFields() {
        gameFields = new HashMap<>();
        gameFields.put(firstGamer, new GameField());
        gameFields.put(secondGamer, new GameField());
    }

    @Override
    public Result shoot(Gamer gamer, Cell cell) {
        return null;
    }

    @Override
    public GameField getGameField(Gamer gamer) {
        return null;
    }

    @Override
    public boolean checkEnd() {
        return false;
    }

    @Override
    public Gamer getWinner() {
        return null;
    }

}
