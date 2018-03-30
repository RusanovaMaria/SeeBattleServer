package domain.game;

import domain.player.Player;
import domain.playingfield.Cell;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassicGameTest {
    private static Player firstPlayer;
    private static Player secondPlayer;
    private static Game game;

    @BeforeClass
    public static void signUp(){
    firstPlayer = new Player(null);
    secondPlayer = new Player(null);
    game = new ClassicGame(firstPlayer, secondPlayer);
}

    @Test
    public void isFindCell(){
        boolean find = game.isFindCell(firstPlayer, new Cell('a', 2));
        assertTrue(find);
    }

    @Test
    public void shoot() {
        Result result = game.shoot(firstPlayer, new Cell('a', 2));
        assertEquals(Result.MISSED, result);
    }

    @Test
    public void isEnd() {
        boolean end = game.isEnd();
        assertFalse(end);
    }

    @Test
    public void getWinner() {
        Player player = game.getWinner();
        assertNull(player);
    }
}