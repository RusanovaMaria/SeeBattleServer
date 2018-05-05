package application.controller;

import application.invitation.AcceptInvitation;
import application.invitation.Invitation;
import application.invitation.NotAcceptInvitation;
import service.ClientHandler;

public class InvitationController implements Controller {

    private ClientHandler clientHandler;

    public InvitationController(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void handle(String answer) {

        switch (answer) {

            case "yes":
                Invitation acceptInvitation = new AcceptInvitation(clientHandler);
                acceptInvitation.handleAnswer();
                break;

                case "no":
                    Invitation notAcceptInvitation = new NotAcceptInvitation(clientHandler);
                    notAcceptInvitation.handleAnswer();
                    break;

                    default:
                        throw new IllegalArgumentException("Введен неверный ответ");
        }
    }
}
