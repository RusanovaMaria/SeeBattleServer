package service.server;

import domain.player.Player;

public class ConnectionController implements Runnable {

    private Player player;
    private ClientHandler clientHandler;
    private boolean ready;
    private State state;

    public ConnectionController(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
        state = State.FREE;
        ready = false;
    }

    public void run() {
        start();

        while (clientHandler.isExist()) {

        }
    }

    private void start() {
        String name = clientHandler.enterName();
        player = new Player(name);
        ready = true;
    }

    public boolean isReady() {
        return ready;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    public Player getPlayer() {
        return player;
    }
}
