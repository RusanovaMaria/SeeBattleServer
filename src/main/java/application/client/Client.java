package application.client;

import domain.player.Player;
import service.ClientHandler;

public class Client {

    private final static String DEFAULT_NAME = "";

    private Client opponent;

    private ClientHandler clientHandler;

    private Player player;

    private ClientStatus status;

    public Client(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
        opponent = null;
        setStatus(ClientStatus.FREE);
        createPlayer();
    }

    private void createPlayer() {

        player = new Player(DEFAULT_NAME);
    }

    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    public Player getPlayer() {
        return player;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public String getName() {

        return player.getName();
    }

    public void setName(String name) {

        player.setName(name);
    }

    public void setOpponent(Client opponent) {

        this.opponent = opponent;
    }

    public Client getOpponent() {

        return opponent;
    }

    public void removeOpponent() {

        opponent = null;
    }

    public boolean hasOpponent() {

        if (opponent != null) {

            return true;
        }

        return false;
    }
}
