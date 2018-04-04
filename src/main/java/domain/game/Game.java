package domain.game;

import domain.player.Player;
import domain.playingfield.Cell;
import domain.playingfield.PlayingField;

import java.util.Map;

public interface Game {
     Result shoot(Player player, Cell cell);

     Cell defineHit(Player player, char y, int x);

     Player getWinner();

     Player getLooser();

     boolean isEnd();

     Map <Player, PlayingField> getPlayingFieldAndPlayerMap();
}
