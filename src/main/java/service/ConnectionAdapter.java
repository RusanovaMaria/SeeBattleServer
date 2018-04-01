package service;

import domain.game.Game;
import domain.player.Player;

import java.util.HashMap;
import java.util.Map;

public class ConnectionAdapter {

    private ClientHandler clientHandler;
    private Map<ClientHandler, Player>  connectionMap;

    public ConnectionAdapter(ClientHandler clientHandler){
        this.clientHandler = clientHandler;
        adaptConnection(clientHandler);
    }

    public Map <ClientHandler, Player> getConnectionMap(){
        return connectionMap;
    }

    private void adaptConnection(ClientHandler clientHandler){
        connectionMap = new HashMap<>();
        Player player = new Player(null);
        connectionMap.put(clientHandler, player);
    }
}
