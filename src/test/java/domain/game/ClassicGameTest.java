package domain.game;

import domain.gameobject.Ship;
import domain.gameobject.gameobjectpart.ShipPart;
import domain.player.Player;
import domain.playingfield.Cell;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
    public void shoot() {
        Result result = game.shoot(firstPlayer, new Cell ('b', 2,new ShipPart(new Ship(4))));
        assertEquals(Result.GOT, result);
    }

    @Test
    public void defineHit(){
        Cell cell = game.defineHit(firstPlayer, 'd', 5 );
        assertNotNull(cell);
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