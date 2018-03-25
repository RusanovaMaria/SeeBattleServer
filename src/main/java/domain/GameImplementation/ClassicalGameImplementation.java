package domain.GameImplementation;

import domain.Cell;
import domain.Game.ActionHandler.ClassicalActionHandler;
import domain.Game.Game;
import domain.Game.Player.Player;
import domain.PlayingFields.PlayingField;

import java.util.Map;

public class ClassicalGameImplementation {

    private Game game;
    private ClassicalActionHandler actionHandler;
    private Map <Player, PlayingField> playingFieldMap;

    public ClassicalGameImplementation(Game game) {
        this.game = game;
        haveGameFields();
    }

    public void play() {
        while (!game.isEnd()) {
            for (Map.Entry<Player, PlayingField> entry : playingFieldMap.entrySet()) {
                Player player = entry.getKey();
            }
        }
    }

    private Cell findCell(char y, int x, PlayingField field){
        Cell cell = field.findCell(y, x);
        return cell;
    }

    private void haveGameFields(){
        playingFieldMap = game.getPlayingFields();
    }
}
