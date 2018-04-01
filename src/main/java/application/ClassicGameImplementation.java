package application;

import domain.game.ClassicGame;
import domain.game.Game;
import domain.game.Result;
import domain.player.Player;
import service.ClientHandler;
import service.ConnectionAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassicGameImplementation implements GameImplementation {

    private ConnectionAdapter firstConnectionAdapter;
    private ConnectionAdapter secondConnectionAdapter;
    private Player firstPlayer;
    private Player secondPlayer;
    private Map<ClientHandler, Player> connectionMap;
    private ArrayList<Player> players;
    private Game game;

    public ClassicGameImplementation(ConnectionAdapter firstConnectionAdapter, ConnectionAdapter secondConnectionAdapter) {
        this.firstConnectionAdapter = firstConnectionAdapter;
        this.secondConnectionAdapter = secondConnectionAdapter;
        initConnectionMap();
        initPlayers();
        createGame();
    }

    @Override
    public void play() {
        while (!game.isEnd()) {
           for (int i = 0; i<players.size(); i++) {
               Player player = players.get(i);
               playMove(player);
           }
        }

        Player winner = game.getWinner();
        Player looser = game.getLooser();

        end(winner, looser);
    }

    private void createGame() {
        game = new ClassicGame(firstPlayer, secondPlayer);
    }

    private void initPlayers() {
        players = new ArrayList<>();

        for (Player player : connectionMap.values()) {
            players.add(player);
        }

        firstPlayer = players.get(0);
        secondPlayer = players.get(1);
    }

    private void initConnectionMap() {
        connectionMap = new HashMap<>();
        connectionMap.putAll(firstConnectionAdapter.getConnectionMap());
        connectionMap.putAll(secondConnectionAdapter.getConnectionMap());
    }

    private void playMove(Player player) {
        int x = inputX(player);
        char y = inputY(player);
        Result result =  game.shoot(player, y, x);
        handleResult(player, result);
    }

    private void handleResult(Player player, Result result){

        ClientHandler clientHandler = findClientHandler(player);

        if (result == Result.MISSED) clientHandler.sendMessage("Мимо");
        if (result == Result.REAPETED) clientHandler.sendMessage("Вы уже стреляли в эту клетку");
        if (result == Result.GOT) clientHandler.sendMessage("Попадание");
        if (result == Result.KILLED) clientHandler.sendMessage("Вы убили корабль противника");
    }

    private char inputY(Player player) {

        ClientHandler clientHandler = findClientHandler(player);
        clientHandler.sendMessage("Введите координату y");
        String message = clientHandler.getMessage();
        message = message.trim();
        char y = message.charAt(0);

        return y;
    }

    private int inputX(Player player) {

        ClientHandler clientHandler = findClientHandler(player);
        clientHandler.sendMessage("Введите координату х");
        String message = clientHandler.getMessage();
        int x = Integer.parseInt(message);

        return x;
    }

    private void end(Player winner, Player looser){
        notifyWinner(winner);
        notifyLooser(looser);
        breakConnection();
    }

    private void notifyWinner(Player player){
        ClientHandler clientHandler = findClientHandler(player);
        clientHandler.sendMessage("You are the winner!");
    }

    private void notifyLooser(Player player){
        ClientHandler clientHandler = findClientHandler(player);
        clientHandler.sendMessage("You are the looser!");
    }

    private void breakConnection(){

        for (ClientHandler clientHandler: connectionMap.keySet()){
            clientHandler.closeAllConnections();
        }
    }

    private ClientHandler findClientHandler(Player player) {
        ClientHandler clientHandler = null;

        for (ClientHandler ch : connectionMap.keySet()) {
            Player p = connectionMap.get(ch);
            if (p.equals(player)) clientHandler = ch;
        }
        return clientHandler;
    }
}
