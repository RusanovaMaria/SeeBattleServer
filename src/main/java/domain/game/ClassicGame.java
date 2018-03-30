package domain.game;

import domain.gameobject.GameObject;
import domain.gameobject.Status;
import domain.gameobject.gameobjectpart.GameObjectPart;
import domain.player.Player;
import domain.playingfield.Cell;
import domain.playingfield.ClassicPlayingField;
import domain.playingfield.PlayingField;

import java.util.HashMap;
import java.util.Map;

public class ClassicGame implements Game {

    private Player firstPlayer;
    private Player secondPlayer;
    private Map<Player, PlayingField> playingFieldMap = new HashMap<>();

    public ClassicGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayingField();
    }

    @Override
    public Result shoot(Player player, Cell cell) {
        Result result = null;

        GameObjectPart shipPart = cell.getGameObjectPart();
        cell.mark();

        if (shipPart == null) {
            if (cell.isLabeled()){
                result = Result.REAPETED;
            } else{
                result = Result.MISSED;
            }
        } else {
            if (shipPart.isAlive()) {
                shipPart.destroy();
                GameObject ship = shipPart.getOwnObject();
                ship.changeStatus();
                Status status = ship.getStatus();
                if (status == Status.KILLED) {
                    result = Result.KILLED;
                } else result = Result.GOT;
            } else {
                result = Result.REAPETED;
            }
        }
        return result;
    }

    @Override
    public boolean isEnd() {
        boolean end = true;

        for (PlayingField playingField : playingFieldMap.values()) {
            if (!playingField.isEmpty()) end = false;
        }
        return end;
    }

    @Override
    public Player getWinner() {
        Player winner = null;

        for (Player player : playingFieldMap.keySet()) {
            PlayingField playingField = playingFieldMap.get(player);
            if (playingField.isEmpty()) winner = player;
        }
        return winner;
    }

    private void initPlayingField() {
        playingFieldMap.put(firstPlayer, new ClassicPlayingField());
        playingFieldMap.put(secondPlayer, new ClassicPlayingField());
    }
}
