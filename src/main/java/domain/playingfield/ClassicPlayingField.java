package domain.playingfield;

import domain.playingfield.cage.Cage;

public class ClassicPlayingField implements PlayingField{

    private final char [] CHAR_COORDINATE = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private final int WIDTH = 10;
    private final int HEIGHT = 10;
    private Cage[][] cages;

    public ClassicPlayingField() {

        generate();
    }

    private void generate() {

        cages = new Cage[WIDTH][HEIGHT];

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                cages[i][j] = new Cage(i, CHAR_COORDINATE[j], null);
            }
        }
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public char[] getCharCoordinate() {
        return CHAR_COORDINATE;
    }
}
