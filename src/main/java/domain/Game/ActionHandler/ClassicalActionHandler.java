package domain;

public class ClassicalActionHandler implements ActionHandler{

    private Player player;
    private Cell cell;

    ClassicalActionHandler(Player player, Cell cell){
        this.player = player;
        this.cell = cell;
    }

    @Override
    public String handleAction() {
        Result result = this.player.action(this.cell);
        String s = "";

        if (result == Result.MISSED){s = "Мимо";}
        else if (result == Result.GOT){s = "Попал";}
        else {s = "Убил";}

        return s;
    }
}
