package application.command;

import service.ClientHandler;

public class HelpCommand extends Command {

    private ClientHandler clientHandler;

    public HelpCommand(ClientHandler clientHandler) {

        this.clientHandler = clientHandler;
    }

    @Override
    public void execute() {

      writeCommandList();
    }

    private void writeCommandList() {

        clientHandler.write("Список команд");
        clientHandler.write("help - помощь");
        clientHandler.write("list - список игроков");
        clientHandler.write("request - отправить запрос на вступление в игру");
    }
}