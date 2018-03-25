package domain.PlayingFields;

import domain.Cell;

public interface PlayingField {

    boolean isEmpty();

    int getSize();

    Cell findCell(char y, int x);

}
