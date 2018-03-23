package domain;

import java.util.List;

public class ClassicalPlayingField implements PlayingField {

    private final int SIZE = 10;

    private Cell[][] cells;

    private List<Ship> ships;

    public ClassicalPlayingField() {
        generateEmptyField();
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!cells[i][j].getUsageSatus()) isEmpty = false;
            }
        }
        return isEmpty;
    }

    private void generate(){

    }

    private void addShips(){

    }

    private void generateEmptyField(){

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                cells [i][j] = new Cell(i, j);

            }
        }
    }


}
