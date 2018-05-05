package application.command;

import application.client.Client;
import application.client.ClientStatus;
import service.ClientHandler;

import java.util.List;

public class PlayerInvitationCommand extends Command {

    private ClientHandler clientHandler;

    public PlayerInvitationCommand(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void execute() {

        makeInvitation();
    }

    private void makeInvitation() {

        Client client = getClient(clientHandler);

        String opponentName = requestOpponentName();
        Client opponent = findOpponentByName(opponentName);

        if (isOpponentFree(opponent)) {

           invite(client, opponent);

        } else {

            clientHandler.write("Соперник с таким именем не найден или не может принять приглашение");
        }
    }

    private String requestOpponentName() {

        clientHandler.write("Введите имя соперника");

        String opponentName = clientHandler.read();

        return opponentName;
    }

    private Client findOpponentByName(String name) {

        List<Client> opponents = clientSet.getClients();

        for (int i = 0; i< opponents.size(); i++) {

            Client opponent = opponents.get(i);

            if (isOpponentName(opponent, name)) {

                return opponent;
            }
        }

        throw new IllegalArgumentException("Игрока с таким именем не существует");
    }

    private boolean isOpponentName(Client opponent, String name) {

        if (opponent.getName().equals(name)) {

            return true;
        }

        return false;
    }

    private boolean isOpponentFree(Client opponent) {

        if (opponent.getStatus().equals(ClientStatus.FREE)) {

            return true;
        }

        return false;
    }

    private void invite (Client client, Client opponent) {

        opponent.setStatus(ClientStatus.INVITED);
        client.setStatus(ClientStatus.INVITING);
        sendInvitationToOpponent(opponent, client);

        createOpponents(client, opponent);
    }

    private void createOpponents (Client client, Client opponent) {

        client.setOpponent(opponent);
        opponent.setOpponent(client);
    }

    private void sendInvitationToOpponent(Client opponent, Client client) {


        ClientHandler opponentClientHandler = opponent.getClientHandler();
        opponentClientHandler.write("С вами хочет играть"+client.getName()+"Введите команду 'yes' или 'no'");
    }
}
