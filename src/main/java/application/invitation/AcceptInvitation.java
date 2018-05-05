package application.invitation;

import application.client.Client;
import application.client.ClientStatus;
import application.gameimplementation.GameImplementation;
import service.ClientHandler;

public class AcceptInvitation extends Invitation {

    private ClientHandler clientHandler;

    public AcceptInvitation(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void handleAnswer(){

        acceptInvitation();
    }

    private void acceptInvitation() {

        Client client = getClient(clientHandler);
        Client opponent = getOpponent(client);
        String message = "Игрок "+client.getName()+" принял ваше предложение";
        notifyOpponent(opponent, message);
        changeStatus(client, ClientStatus.IN_GAME);
        changeStatus(opponent, ClientStatus.IN_GAME);
        startGame(client, opponent);
    }

    private void startGame(Client client, Client opponent) {

        GameImplementation gameImplementation = new GameImplementation(client, opponent);

        Thread t = new Thread(gameImplementation);
        t.start();
    }
}
