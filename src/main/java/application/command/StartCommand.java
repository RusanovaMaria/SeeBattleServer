package application.command;

import application.client.Client;
import service.ClientHandler;

public class StartCommand extends Command {

    private ClientHandler clientHandler;

    public StartCommand(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void execute() {

        start();
    }

    private void start() {

        String name = requestName();
        Client client = getClient(clientHandler);
        giveNameToClient(client, name);
    }

    private String requestName() {

        clientHandler.write("Введите свое имя");
        String name = clientHandler.read();

        return name;
    }

    private void giveNameToClient(Client client, String name) {

        client.setName(name);
    }
}
