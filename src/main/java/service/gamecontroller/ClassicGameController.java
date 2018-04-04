package service.gamecontroller;

import domain.game.ClassicGame;
import domain.game.Game;
import domain.game.Result;
import domain.player.Player;
import domain.playingfield.Cell;
import service.server.ClientHandler;
import service.server.ConnectionController;
import service.server.Server;

import java.util.HashMap;
import java.util.Map;

public class ClassicGameController implements GameController {

    private ConnectionController firstConnectionController;
    private ConnectionController secondConnectionController;
    private Player firstPlayer;
    private Player secondPlayer;
    private Map<Player, ClientHandler> playerAndHandler;
    private Game game;

    public ClassicGameController(ConnectionController firstConnectionController, ConnectionController secondConnectionController) {

        this.firstConnectionController = firstConnectionController;
        this.secondConnectionController = secondConnectionController;
        initPlayerAndHandlerMap();
        createGame();
    }

    private void initPlayerAndHandlerMap() {
        playerAndHandler = new HashMap<>();

        firstPlayer = firstConnectionController.getPlayer();
        ClientHandler firstClientHandler = firstConnectionController.getClientHandler();
        playerAndHandler.put(firstPlayer, firstClientHandler);

        secondPlayer = secondConnectionController.getPlayer();
        ClientHandler secondClientHandler = secondConnectionController.getClientHandler();
        playerAndHandler.put(secondPlayer, secondClientHandler);
    }

    private void createGame() {
        game = new ClassicGame(firstPlayer, secondPlayer);
    }

    public void play() {
        while (!game.isEnd()) {
            for (Player player : playerAndHandler.keySet()) {
                playMove(player);
            }
        }

        end();
    }

    private void playMove(Player player) {
        char y = inputY(player);
        int x = inputX(player);
        Cell cell = game.defineHit(player, y, x);
        Result result = game.shoot(player, cell);
        processPlayMove(player, result);
    }

    private char inputY(Player player) {
        char y = ' ';
        ClientHandler clientHandler = playerAndHandler.get(player);

        clientHandler.sendMessage("Введите координату y");
        String message = clientHandler.getMessage().trim();
        y = message.charAt(0);

        return y;
    }

    private int inputX(Player player) {
        int x = -1;
        ClientHandler clientHandler = playerAndHandler.get(player);

        clientHandler.sendMessage("Введите координату х");
        String message = clientHandler.getMessage();
        x = Integer.parseInt(message);

        return x;
    }

    private void processPlayMove(Player player, Result result) {

        ClientHandler clientHandler = playerAndHandler.get(player);

        switch (result) {

            case MISSED:
                clientHandler.sendMessage("Мимо");
                break;

            case REAPETED:
                clientHandler.sendMessage("Вы уже стреляли в эту клетку");
                playMove(player);
                break;

            case GOT:
                clientHandler.sendMessage("Попал");
                break;

            case KILLED:
                clientHandler.sendMessage("Убил");
        }
    }

    private void end() {
        notifyWinner();
        notifyLooser();
        breakConnection();
    }

    private void notifyWinner() {
        Player player = game.getWinner();
        ClientHandler clientHandler = playerAndHandler.get(player);
        clientHandler.sendMessage("Вы победили!");
    }

    private void notifyLooser() {
        Player player = game.getLooser();
        ClientHandler clientHandler = playerAndHandler.get(player);
        clientHandler.sendMessage("Вы проиграли");
    }

    private void breakConnection() {
        for (ClientHandler clientHandler : playerAndHandler.values()) {
            clientHandler.closeAllConnections();
        }
    }
}
