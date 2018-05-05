package application.command;

import application.client.Client;
import service.ClientHandler;

import java.util.ArrayList;
import java.util.List;

public class PlayerListCommand extends Command {

    private ClientHandler clientHandler;

    public PlayerListCommand(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void execute() {

        writeOpponentList();

    }

    private void writeOpponentList() {

        List<Client> opponents = clientSet.getClients();

        for (int i = 0; i < opponents.size(); i++) {

            Client opponent = opponents.get(i);

                writeOpponentName(opponent);
        }
    }

    private void writeOpponentName(Client opponent) {

        clientHandler.write(opponent.getName());
    }
}
