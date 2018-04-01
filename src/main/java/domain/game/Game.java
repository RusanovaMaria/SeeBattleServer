package domain.game;

import domain.player.Player;
import domain.playingfield.Cell;
import domain.playingfield.PlayingField;

import java.util.Map;

public interface Game {
    public Result shoot(Player player, char y, int x);

    public Player getWinner();

    public Player getLooser();

    public boolean isEnd();

    public Map <Player, PlayingField> getPlayingFieldAndPlayerMap();
}
