package application.invitation;

import application.client.Client;
import application.client.ClientStatus;
import service.ClientHandler;

public class NotAcceptInvitation extends Invitation {

    private ClientHandler clientHandler;

    public NotAcceptInvitation(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void handleAnswer() {

        notAcceptInvitation();
    }

    private void notAcceptInvitation() {

        Client client = getClient(clientHandler);
        Client opponent = getOpponent(client);
        String message = "Игрок"+client.getName()+"отклонил ваше предложение";
        notifyOpponent(opponent, message);
        removeOpponent(client);
        changeStatus(client, ClientStatus.FREE);
    }


}
