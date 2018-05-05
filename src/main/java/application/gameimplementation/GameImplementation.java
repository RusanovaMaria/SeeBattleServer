package application.gameimplementation;

import application.client.Client;
import application.client.ClientStatus;
import domain.game.ClassicGame;
import domain.game.Game;
import domain.player.Player;
import service.ClientHandler;

import java.util.HashMap;
import java.util.Map;

public class GameImplementation implements Runnable{

    private Client firstClient;

    private Client secondClient;

    private  Game game;

    private Map<Client, Boolean> moves;

    private GameImplementationSet gameImplementationSet;

    public GameImplementation(Client firstClient, Client secondClient) {

        this.firstClient = firstClient;
        this.secondClient = secondClient;

        initMoves();
        createGame();
        addToGameImplementationSet();
    }

    private void createGame() {

        Player firstPlayer = firstClient.getPlayer();
        Player secondPlayer = secondClient.getPlayer();

        game = new ClassicGame(firstPlayer, secondPlayer);
    }

    private void initMoves() {

        moves = new HashMap<>();

        moves.put(firstClient, true);
        moves.put(secondClient, false);
    }

    private void addToGameImplementationSet() {

        gameImplementationSet = new GameImplementationSet();
        gameImplementationSet.add(this);
    }

    @Override
    public void run() {

        play();
    }

    public void play() {

        while (!game.isEnd()) {

            for (Client client: moves.keySet()) {

                if (isClientMove(client)) {
                    move(client);
                }

                while (isClientMove(client)) {
                    //System.out.println(isClientMove(client));
                }
            }
        }

        gameImplementationSet.remove(this);
        firstClient.setStatus(ClientStatus.FREE);
        secondClient.setStatus(ClientStatus.FREE);
    }

    private void move(Client client) {

            ClientHandler clientHandler = client.getClientHandler();
            clientHandler.write("Введите координаты х и у");
    }

    public boolean isClientMove(Client client) {

        return moves.get(client).equals(true);
    }

    public void passMove(Client client) {

        Client opponent = client.getOpponent();

       moves.put(client, false);
       moves.put(opponent, true);
    }

    public boolean isClientInGame(Client client) {

        if ((client.equals(firstClient)) || (client.equals(secondClient))) {

            return true;
        }

        return false;
    }

    public Game getGame() {

        return game;
    }
}
