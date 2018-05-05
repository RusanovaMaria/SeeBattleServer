package application.controller;

import application.client.ClientSet;
import application.command.*;
import javafx.scene.web.HTMLEditorSkin;
import service.ClientHandler;

public class CommandController implements Controller{

    private final String[] commands = {"start", "help", "list", "request"};

    private ClientHandler clientHandler;

    public CommandController(ClientHandler clientHandler) {

       this.clientHandler = clientHandler;
    }

    @Override
    public void handle(String command) {

        if (isRightCommand(command)) {

            handleCommand(command);

        } else {

            Command helpCommand = new HelpCommand(clientHandler);
            helpCommand.execute();
        }
    }

    private boolean isRightCommand(String command) {

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(command)) {
                return true;
            }
        }

        return false;
    }


    private void handleCommand(String command) {

        switch (command) {

            case "start":
                Command startCommand = new StartCommand(clientHandler);
                startCommand.execute();
                break;

            case "help":
                Command helpCommand = new HelpCommand(clientHandler);
                helpCommand.execute();
                break;

            case "list":
                Command listCommand = new PlayerListCommand(clientHandler);
                listCommand.execute();
                break;

            case "request":
                Command requestCommand = new PlayerInvitationCommand(clientHandler);
                requestCommand.execute();
                break;

            default:
                throw new IllegalArgumentException("Данного запроса не существует");
        }
    }
}