package domain.playingfield;

import domain.gameobject.GameObject;
import domain.gameobject.gameobjectpart.GameObjectPart;
import domain.gameobject.gameobjectpart.ShipPart;
import domain.rule.ClassicRule;
import domain.rule.Rule;
import domain.gameobject.Ship;

import java.util.ArrayList;
import java.util.Random;

public class ClassicPlayingField implements PlayingField {

    private final int SIZE = 10;
    private final char[] CHAR_COORDINATE = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private Cell[][] cells;
    private ArrayList<Ship> ships;

    public ClassicPlayingField() {

    }

    public int getSize() {
        return SIZE;
    }

    private void generate() {
        generateEmptyField();
        for (int i = 0; i<ships.size(); i++){
            Ship ship = ships.get(i);
            ArrayList<GameObjectPart> shipParts = ship.getAllParts();
            Cell [] useCells = new Cell[shipParts.size()];

        }
    }

    private void generateEmptyField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char y = CHAR_COORDINATE[i];
                int x = j;
                cells[i][j] = new Cell(y, x, null);
            }
        }
    }

    private void addShips() {
        Rule rule = new ClassicRule();
        int[] shipsSize = rule.getGameObjectsSize();

        for (int i = 0; i < shipsSize.length; i++) {
            int size = shipsSize[i];
            Ship ship = new Ship(size);
            int number = rule.countNumberOfObjects(ship.getKind());
            for (int j = 0; j < number; j++) {
                ships.add(ship);
            }
        }
    }

    private char generateRandomY(){
        Random random = new Random();
        int index = (0 + random.nextInt(CHAR_COORDINATE.length));
        char y = CHAR_COORDINATE[index];
        return y;
    }

    private int generateRandomX(){
      Random random = new Random();
      int x = (0 + random.nextInt(SIZE));
      return x;
    }
}
