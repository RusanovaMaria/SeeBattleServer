package application.client;

import domain.player.Player;
import service.ClientHandler;

import java.util.ArrayList;
import java.util.List;

public class ClientSet {

    private final static List<Client> clients = new ArrayList();

    public void add(Client client) {

        clients.add(client);
    }

    public Client findClientByClientHandler(ClientHandler clientHandler) {

        for (Client client: clients) {

            if (client.getClientHandler().equals(clientHandler)) {
                return client;
            }
        }

        throw new IllegalArgumentException("Клиент с таким параметром не обнаружен");
    }

    public Client findClientHandlerByPlayer(Player player) {

        for (Client client: clients) {

            if (client.getPlayer().equals(player)) {
                return client;
            }
        }

        throw new IllegalArgumentException("Клиент с таким параметром не обнаружен");
    }

    public static List<Client> getClients() {
        return clients;
    }
}
