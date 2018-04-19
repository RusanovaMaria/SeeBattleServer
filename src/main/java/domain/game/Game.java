package domain;

import java.util.Map;

public interface Game {

    boolean isEnd();

    Map<Player, PlayingField> getPlayers();
}
