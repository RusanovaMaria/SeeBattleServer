package application.controller;

import application.client.Client;
import application.client.ClientSet;
import application.client.ClientStatus;
import service.ClientHandler;

public class ControllerManager {

    private ClientHandler clientHandler;

    private ClientSet clientSet = new ClientSet();

    public ControllerManager(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

        public void handle(String command) {

        ClientStatus clientStatus = identifyClientStatus();

        Controller controller = identifyControllerByClientStatus(clientStatus);

        controller.handle(command);
        }

        private ClientStatus identifyClientStatus() {

            Client client = clientSet.findClientByClientHandler(clientHandler);

            ClientStatus clientStatus = client.getStatus();

            return clientStatus;
        }

        private Controller identifyControllerByClientStatus(ClientStatus status) {

            switch (status) {

                case FREE:
                    return new CommandController(clientHandler);

                case INVITED:
                    return new InvitationController(clientHandler);

                case IN_GAME:
                    return new GameController(clientHandler);
            }

            throw new IllegalArgumentException("Данный статус клиента не распознан");
        }
    }

