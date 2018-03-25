package domain.Game;

import domain.Game.Player.Player;

import java.util.Map;

public interface Game {
    boolean isEnd();

    Player getWinner();

    Map getPlayingFields();

}
