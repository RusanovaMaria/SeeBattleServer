package application;

import domain.player.Player;
import service.ClientHandler;

public class Client {

    private ClientHandler clientHandler;

    public Client(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
        createPlayer();
    }

    private void createPlayer() {

        Player player = new Player(null);
    }
}
