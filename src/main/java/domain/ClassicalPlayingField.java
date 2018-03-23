package domain;

import java.util.List;

public class ClassicalPlayingField implements PlayingField{

    private final int SIZE = 10;

    private Cell[][] cells;

    private List<Ship> ships;

    public ClassicalPlayingField() {
        generateEmptyField();
    }

    @Override
    public Cell[][] getCellList(){
        return cells;
    }

    private void generate(){

    }

    private void addShips(){

    }

    private void generateEmptyField(){

        Cell cell = new Cell(CellStatus.EMPTY);

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                cells [i][j] = cell;
            }
        }
    }


}
