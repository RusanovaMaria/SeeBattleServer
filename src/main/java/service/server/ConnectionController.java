package service.server;

import domain.player.Player;

public class ConnectionController {

    private Player player;
    private ClientHandler clientHandler;

    public ConnectionController(ClientHandler clientHandler){
        this.clientHandler = clientHandler;
    }


}
