package domain.game;

import domain.player.Player;
import domain.playingfield.Cell;
import domain.playingfield.ClassicPlayingField;
import domain.playingfield.PlayingField;

import java.util.Map;

public class ClassicGame implements Game {

    private Player firstPlayer;
    private Player secondPlayer;
    private Map<Player, PlayingField> playingFieldMap;

    public ClassicGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayingField();
    }

    @Override
    public void shoot(Player player, Cell cell) {

    }

    @Override
    public boolean isEnd() {
       return false;
    }

    @Override
    public Player getWinner() {
      return firstPlayer;
    }

    private void initPlayingField() {
        playingFieldMap.put(firstPlayer, new ClassicPlayingField());
        playingFieldMap.put(secondPlayer, new ClassicPlayingField());
    }
}
