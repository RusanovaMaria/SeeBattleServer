package application.invitation;

import application.client.Client;
import application.client.ClientSet;
import application.client.ClientStatus;
import service.ClientHandler;

public abstract class Invitation {

    protected ClientSet clientSet = new ClientSet();

    public abstract void handleAnswer();

    protected void changeStatus(Client client, ClientStatus status) {

        client.setStatus(status);
    }

    protected void removeOpponent(Client client) {

        client.removeOpponent();
    }

    protected void notifyOpponent(Client opponent, String message) {

        ClientHandler opponentClientHandler = opponent.getClientHandler();

        opponentClientHandler.write(message);
    }

    protected Client getOpponent(Client client) {

        return client.getOpponent();
    }

    public Client getClient(ClientHandler clientHandler) {

        Client client = clientSet.findClientByClientHandler(clientHandler);

        return client;
    }
}
