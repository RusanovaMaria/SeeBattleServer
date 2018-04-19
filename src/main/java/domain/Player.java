package domain;

import domain.playingfield.ClassicPlayingField;

public class Player {

    private String name;
    private ClassicPlayingField playingField;

    public Player (String name) {

        this.name = name;
        createPlayingField();
    }

    private void createPlayingField() {
        playingField = new ClassicPlayingField();
    }

    public String getName() {
        return name;
    }

    public ClassicPlayingField getPlayingField() {
        return playingField;
    }
}
