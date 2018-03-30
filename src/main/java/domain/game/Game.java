package domain.game;

import domain.player.Player;
import domain.playingfield.Cell;

public interface Game {
    public Result shoot(Player player, Cell cell);
    public Player getWinner();
    public boolean isEnd();

    public boolean isFindCell(Player firstPlayer, Cell a);
}
