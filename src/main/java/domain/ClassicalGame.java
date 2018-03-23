package domain;

import java.util.HashMap;
import java.util.Map;

public class ClassicalGame implements Game {

    private Map<Player, PlayingField> playingFields;
    private  Player firstPlayer;
    private Player secondPlayer;

    ClassicalGame(Player firstPlayer, Player secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayFields();
    }

    @Override
    public Result shoot(Player player, Cell cell) {
        Result result;
        if (cell.getUsageSatus()== true){

        }
        else result = Result.MISSED;
        return result;
    }

    @Override
    public boolean checkEnd() {
        boolean isEnd = false;
        for (PlayingField field : playingFields.values()){
            field = new ClassicalPlayingField();
            if (field.isEmpty()) isEnd = true;
            }
            return isEnd;
        }

    @Override
    public Player getWinner() {
        Player player;
        PlayingField playingField;

        for (Player p : playingFields.keySet()){
            playingField = new ClassicalPlayingField();
            playingField = playingFields.get(p);

            if (!playingField.isEmpty()) return p;

            }

        return null;
    }

    private void initPlayFields(){
        playingFields = new HashMap<>();
        playingFields.put(firstPlayer, new ClassicalPlayingField());
        playingFields.put(secondPlayer, new ClassicalPlayingField());
    }
}
