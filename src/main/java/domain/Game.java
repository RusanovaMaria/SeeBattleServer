package domain;

public interface Game {
Result shoot(Player player, Cell cell);
boolean checkEnd();
Player getWinner();
}
