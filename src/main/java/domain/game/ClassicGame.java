package domain;

import java.util.HashMap;
import java.util.Map;

public class ClassicGame implements Game {

    private Player firstPlayer;
    private Player secondPlayer;
    private Map<Player, PlayingField> players;

    public ClassicGame(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        init();
    }

    private void init() {

        players = new HashMap<>();

        players.put(firstPlayer, new PlayingField());
        players.put(secondPlayer, new PlayingField());
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public Map<Player, PlayingField> getPlayers() {
        return players;
    }
}

