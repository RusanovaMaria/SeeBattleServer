package domain;

import java.util.HashMap;
import java.util.Map;

public class ClassicalGame implements Game {

    private Map<Player, PlayingField> gameFields;
    private  Player firstPlayer;
    private Player secondPlayer;

    ClassicalGame(Player firstPlayer, Player secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayFields();
    }

    @Override
    public Result shoot(Player player, Cell cell) {
        return null;
    }

    @Override
    public boolean checkEnd() {
        boolean isEnd = true;
        for (PlayingField field : gameFields.values()){
            field = new ClassicalPlayingField();

        }
    }

    @Override
    public Player getWinner() {
        return null;
    }

    private void initPlayFields(){
        gameFields = new HashMap<>();
        gameFields.put(firstPlayer, new ClassicalPlayingField());
        gameFields.put(secondPlayer, new ClassicalPlayingField());
    }
}
