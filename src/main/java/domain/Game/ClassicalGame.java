package domain.Game;

import domain.Cell;
import domain.Game.Player.ClassicalPlayer;
import domain.PlayingFields.ClassicalPlayingField;
import domain.Game.Player.Player;
import domain.PlayingFields.PlayingField;

import java.util.HashMap;
import java.util.Map;

public class ClassicalGame implements Game {

    private Map<Player, PlayingField> playingFields;
    private Player firstPlayer;
    private Player secondPlayer;

    public ClassicalGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayFields();
    }

    @Override
    public boolean isEnd() {
        boolean isEnd = false;
        for (PlayingField field : playingFields.values()) {
            field = new ClassicalPlayingField();
            if (field.isEmpty()) isEnd = true;
        }
        return isEnd;
    }

    @Override
    public Player getWinner() {
        Player player;
        PlayingField playingField;

        for (Player p : playingFields.keySet()) {
            playingField = playingFields.get(p);

            if (!playingField.isEmpty()) return p;

        }

        return null;
    }

    @Override
    public Map<Player, PlayingField> getPlayingFields() {
        return playingFields;
    }

    private void initPlayFields() {
        playingFields = new HashMap<>();
        playingFields.put(firstPlayer, new ClassicalPlayingField());
        playingFields.put(secondPlayer, new ClassicalPlayingField());
    }

}
