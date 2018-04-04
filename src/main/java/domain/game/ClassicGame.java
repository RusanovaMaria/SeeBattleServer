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
    private Map<Player, PlayingField> playingFieldAndPlayerMap = new HashMap<>();

    public ClassicGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayingField();
    }

    @Override
    public Result shoot(Player player, Cell cell) {
        Result result = null;

        System.out.println(cell);

        if (cell.isLabeled()) {
            result = Result.REAPETED;
        } else {
            if (cell.getGameObjectPart() == null) {
                result = Result.MISSED;
            } else {
                GameObjectPart shipPart = cell.getGameObjectPart();
                shipPart.destroy();
                GameObject ship = shipPart.getOwnObject();
                ship.getStatus();
                Status status = ship.getStatus();
                if (status == Status.KILLED) {
                    result = Result.KILLED;
                } else {
                    result = Result.GOT;
                }
            }
            cell.mark();
        }
        return result;
    }

    @Override
    public Cell defineHit (Player player, char y, int x){
        Cell cell = null;

        PlayingField playingField = playingFieldAndPlayerMap.get(player);
        Cell [] [] cells = playingField.getCells();

        for (int i = 0; i<cells.length; i++){
            for (int j = 0; j < cells.length; j++){
                if ((cells[i][j].getY() == y) && (cells[i][j].getX() == x)) cell = cells[i][j];
                System.out.println("y:");
                System.out.println( cells[i][j].getY() == y);
                System.out.println("x:");
                System.out.println(cells[i][j].getX() == x);
            }
        }
        return cell;
    }

    @Override
    public boolean isEnd() {
        boolean end = true;

        for (PlayingField playingField : playingFieldAndPlayerMap.values()) {
            if (!playingField.isEmpty()) end = false;
        }
        return end;
    }

    @Override
    public Player getWinner() {
        Player winner = null;

        for (Player player : playingFieldAndPlayerMap.keySet()) {
            PlayingField playingField = playingFieldAndPlayerMap.get(player);
            if (playingField.isEmpty()) winner = player;
        }
        return winner;
    }

    @Override
    public Player getLooser(){
        Player looser = null;

        Player winner = getWinner();

        for (Player player: playingFieldAndPlayerMap.keySet()){
            if (!player.equals(winner)) looser = player;
        }
        return looser;
    }

    @Override
    public Map<Player, PlayingField> getPlayingFieldAndPlayerMap(){
        return playingFieldAndPlayerMap;
    }

    private void initPlayingField() {
        playingFieldAndPlayerMap.put(firstPlayer, new ClassicPlayingField());
        playingFieldAndPlayerMap.put(secondPlayer, new ClassicPlayingField());
    }
}
