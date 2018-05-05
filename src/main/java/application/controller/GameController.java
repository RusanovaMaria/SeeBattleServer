package application.controller;

import application.client.Client;
import application.client.ClientSet;
import application.gameimplementation.GameImplementation;
import application.gameimplementation.GameImplementationSet;
import domain.game.Game;
import domain.game.Result;
import domain.player.Player;
import service.ClientHandler;

public class GameController implements Controller {

    private ClientHandler clientHandler;

    private ClientSet clientSet = new ClientSet();

    private GameImplementationSet gameImplementationSet = new GameImplementationSet();

    public GameController(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void handle(String message) {

        Client client = clientSet.findClientByClientHandler(clientHandler);
        GameImplementation gameImplementation = gameImplementationSet.findGameImplementationByClient(client);

        if (gameImplementation.isClientMove(client)) {

            String coordinates = message.trim();

            makeMove(client, gameImplementation, coordinates);

        } else {

              notifyAboutMistake();
        }
    }

    private int getX(String coordinates) {

        int x = Integer.parseInt(coordinates.substring(0, 1));

        return x;
    }

    private char getY(String coordinates) {

        char y = coordinates.charAt(1);

        return y;
    }

    private void makeMove(Client client, GameImplementation gameImplementation, String coordinates) {


        int x = getX(coordinates);
        char y = getY(coordinates);

        Game game = gameImplementation.getGame();
        Result result = game.fire(client.getPlayer(), x, y);
        getAnswerByResult(result);
        gameImplementation.passMove(client);
    }

    private void getAnswerByResult (Result result) {

        switch (result) {

            case MISSED:
                clientHandler.write("Мимо");
                break;

            case REPEATED:
                clientHandler.write("Вы уже стреляли в эту клетку");
                break;

            case GOT:
                clientHandler.write("Попадание");
                break;

            case KILLED:
                clientHandler.write("Убит");
        }
    }

    private void notifyAboutMistake() {

        clientHandler.write("Сейчас не ваш ход");
    }
}
