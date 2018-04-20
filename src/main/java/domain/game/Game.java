package domain.game;

import domain.Player.Player;
import domain.playingfield.ClassicPlayingField;

import java.util.Map;

public interface Game {

    boolean isEnd();

    Map<Player, ClassicPlayingField> getPlayers();
}
