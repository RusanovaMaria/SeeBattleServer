package domain.playingfield;

import domain.gameobject.GameObject;
import domain.gameobject.Status;
import domain.gameobject.gameobjectpart.GameObjectPart;
import domain.rule.ClassicRule;
import domain.rule.Rule;
import domain.gameobject.Ship;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class ClassicPlayingField implements PlayingField {

    private static final Logger log = Logger.getLogger(ClassicPlayingField.class);

    private final int MIN = 0;
    private final int SIZE = 10;
    private final char[] CHAR_COORDINATE = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private Cell[][] cells = new Cell[SIZE][SIZE];
    private ArrayList<GameObject> ships = new ArrayList<GameObject>();

    public ClassicPlayingField() {
        generate();
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isEmpty() {
        boolean empty = true;

        for (int i = 0; i < ships.size(); i++) {
            GameObject ship = ships.get(i);
            if (ship.getStatus() != Status.KILLED) empty = false;
        }
        return empty;
    }

    @Override
    public Cell [][] getCells(){
        return cells;
    }

    private void generate() {
        generateEmptyField();
        addShips();

        int x = -1;
        int y = -1;
        for (int i = 0; i < ships.size(); i++) {
            GameObject ship = ships.get(i);

            while (true) {
                y = generateRandomY();
                x = generateRandomX();

                if (isProperPlace(x, y, ship)) break;
            }

            if (isProperPlaceToTheRight(x, y, ship)) positionShipToTheRight(x, y, ship);
            else if (isProperPlaceToTheLeft(x, y, ship)) positionShiptoTheLeft(x, y, ship);
            else if (isProperPlaceOnTop(x, y, ship)) positionShipOnTop(x, y, ship);
            else if (isProperPlaceAtTheBottom(x, y, ship)) positionShipAtTheBottom(x, y, ship);
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cells[i][j].getGameObjectPart() + " ");
            }
            System.out.println();
        }
        System.out.println();
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
            GameObject ship = new Ship(size);
            int number = rule.countNumberOfObjects(ship.getKind());
            for (int j = 0; j < number; j++) {
                ships.add(ship);
            }
        }
    }

    private int generateRandomY() {
        Random random = new Random();
        int y = (0 + random.nextInt(SIZE - 1));
        return y;
    }

    private int generateRandomX() {
        Random random = new Random();
        int x = (0 + random.nextInt(SIZE - 1));
        return x;
    }

    private boolean isProperPlace(int x, int y, GameObject ship) {
        boolean properPlace = false;

        if (isProperPlaceToTheRight(x, y, ship)) properPlace = true;
        if (isProperPlaceToTheLeft(x, y, ship)) properPlace = true;
        if (isProperPlaceOnTop(x, y, ship)) properPlace = true;
        if (isProperPlaceAtTheBottom(x, y, ship)) properPlace = true;

        return properPlace;
    }

    private boolean isProperPlaceToTheRight(int x, int y, GameObject ship) {
        boolean properPlace = true;

        for (int i = x; i <= x + ship.getSize() + 1; i++) {
            if ((i >= SIZE) || (cells[i][y].getGameObjectPart() != null) || ((y + 1 < SIZE) && (cells[i][y + 1].getGameObjectPart() != null)) || ((y - 1 >= MIN) && (cells[i][y + 1].getGameObjectPart() != null))) {
                properPlace = false;
            }
        }
        return properPlace;
    }

    private boolean isProperPlaceToTheLeft(int x, int y, GameObject ship) {
        boolean properPlace = true;

        for (int i = x - ship.getSize() - 1; i <= x + 1; i++) {
            if ((i < MIN) || (cells[i][y].getGameObjectPart() != null) || ((y + 1 < SIZE) && (cells[i][y + 1].getGameObjectPart() != null)) || ((y - 1 >= MIN) && (cells[i][y + 1].getGameObjectPart() != null))) {
                properPlace = false;
            }
        }

        return properPlace;
    }

    private boolean isProperPlaceAtTheBottom(int x, int y, GameObject ship) {
        boolean properPlace = true;

        for (int i = y; i <= y + ship.getSize() + 1; i++) {
            if ((i >= SIZE) || (cells[x][i].getGameObjectPart() != null) || ((x + 1 < SIZE) && (cells[x + 1][i].getGameObjectPart() != null)) || ((x - 1 >= MIN) && (cells[x - 1][i].getGameObjectPart() != null))) {
                properPlace = false;
            }
        }
        return properPlace;
    }

    private boolean isProperPlaceOnTop(int x, int y, GameObject ship) {
        boolean properPlace = true;

        for (int i = y - ship.getSize() - 1; i <= y + 1; i++) {
            if ((i < MIN) || (cells[x][i].getGameObjectPart() != null) || ((x + 1 < SIZE) && (cells[x + 1][i].getGameObjectPart() != null)) || ((x - 1 >= MIN) && (cells[x - 1][i].getGameObjectPart() != null))) {
                properPlace = false;
            }
        }

        return properPlace;
    }

    private void positionShipToTheRight(int x, int y, GameObject ship) {
        ArrayList<GameObjectPart> shipParts = ship.getAllParts();

        for (int i = x; i < x + ship.getSize(); i++) {
            for (int j = 0; j < ship.getSize(); j++) {
                cells[i][y] = new Cell(CHAR_COORDINATE[y], i, shipParts.get(j));
            }
        }
    }

    private void positionShiptoTheLeft(int x, int y, GameObject ship) {
        ArrayList<GameObjectPart> shipParts = ship.getAllParts();

        for (int i = x - ship.getSize(); i < x; i++) {
            for (int j = 0; j < ship.getSize(); j++) {
                cells[i][y] = new Cell(CHAR_COORDINATE[y], i, shipParts.get(j));
            }
        }
    }

    private void positionShipAtTheBottom(int x, int y, GameObject ship) {
        ArrayList<GameObjectPart> shipParts = ship.getAllParts();

        for (int i = y; i < y + ship.getSize(); i++) {
            for (int j = 0; j < ship.getSize(); j++) {
                cells[x][i] = new Cell(CHAR_COORDINATE[i], x, shipParts.get(j));
            }
        }
    }

    private void positionShipOnTop(int x, int y, GameObject ship) {
        ArrayList<GameObjectPart> shipParts = ship.getAllParts();

        for (int i = y - ship.getSize(); i < y; i++) {
            for (int j = 0; j < ship.getSize(); j++) {
                cells[x][i] = new Cell(CHAR_COORDINATE[i], x, shipParts.get(j));
            }
        }
    }
}
