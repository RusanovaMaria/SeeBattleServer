package domain.GameImplementation;

import domain.Cell;
import domain.Game.ActionHandler.ActionHandler;
import domain.Game.ActionHandler.ClassicalActionHandler;
import domain.Game.Game;
import domain.Game.Player.Player;
import domain.PlayerHandler;
import domain.PlayingFields.PlayingField;

import java.util.Map;

public class ClassicalGameImplementation {

    private Game game;
    private ClassicalActionHandler actionHandler;
    private Map<Player, PlayingField> playingFieldMap;
    private Map<PlayerHandler, ActionHandler> handlerMap;

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

    private void haveGameFields() {
        playingFieldMap = game.getPlayingFields();
    }

    private void returnResult(PlayerHandler playerHandler) {

    }
}
