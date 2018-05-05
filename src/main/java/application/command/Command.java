package application.command;

import application.client.Client;
import application.client.ClientSet;
import service.ClientHandler;

public abstract class Command {

    protected ClientSet clientSet = new ClientSet();

    public abstract void execute();

    protected Client getClient(ClientHandler clientHandler) {

       Client client = clientSet.findClientByClientHandler(clientHandler);

       return client;
    }
}
