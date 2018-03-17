import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Gamer firstGamer;
    private Gamer secondGamer;
    private GameField gameField;
    private int[][] firstGameField;
    private int[][] secondGameField;

    Game(Gamer firstGamer, Gamer secondGamer) {
        this.firstGamer = firstGamer;
        this.secondGamer = secondGamer;
    }

    public void play() {
        int x = -1;
        int y = -1;
        generateGameFields();
        while (!endOfTheGame()) {
            requestAndGetXCoordinate(firstGamer);
            requestAndGetYCoordinate(firstGamer);
            if (endOfTheGame()) {
                firstGamer.sendMessage("You are the winner");
                secondGamer.sendMessage("You are the looser");
            } else {
                requestAndGetXCoordinate(secondGamer);
                requestAndGetYCoordinate(secondGamer);
                if (endOfTheGame()) {
                    secondGamer.sendMessage("You are the winner");
                    firstGamer.sendMessage("You are the looser");
                }
            }
        }
    }
    private void generateGameFields() {
        gameField = new GameField();
        firstGameField = gameField.generate();
        secondGameField = gameField.generate();
    }
    private int requestAndGetXCoordinate(Gamer gamer) {
        int x = -1;
        gamer.sendMessage("Enter the x-coordinate");
        x = gamer.getCoordinate();
        return x;
    }
    private int requestAndGetYCoordinate(Gamer gamer) {
        int y = -1;
        gamer.sendMessage("Enter the y-coordinate");
        y = gamer.getCoordinate();
        return y;
    }
    public String fight(int x, int y, int[][] gameField) {
        String result;
        if (gameField[x][y] == 1) {
            result = "Попал";
        } else result = "Мимо";
        return result;
    }
    public boolean endOfTheGame() {
        boolean isEnd = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((firstGameField[i][j] == 1) || (secondGameField[i][j] == 1)) isEnd = false;
            }
        }
        return isEnd;
    }
}
