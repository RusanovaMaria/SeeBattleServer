package domain;

import java.util.HashMap;
import java.util.Map;

public class ClassicalGame implements Game {

    private Map<ClassicalPlayer, PlayingField> playingFields;
    private ClassicalPlayer firstPlayer;
    private ClassicalPlayer secondPlayer;

    ClassicalGame(ClassicalPlayer firstPlayer, ClassicalPlayer secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initPlayFields();
    }

    @Override
    public boolean checkEnd() {
        boolean isEnd = false;
        for (PlayingField field : playingFields.values()){
            field = new ClassicalPlayingField();
            if (field.isEmpty()) isEnd = true;
            }
            return isEnd;
        }

    @Override
    public ClassicalPlayer getWinner() {
        ClassicalPlayer player;
        PlayingField playingField;

        for (ClassicalPlayer p : playingFields.keySet()){
            playingField = new ClassicalPlayingField();
            playingField = playingFields.get(p);

            if (!playingField.isEmpty()) return p;

            }

        return null;
    }

    private void initPlayFields(){
        playingFields = new HashMap<>();
        playingFields.put(firstPlayer, new ClassicalPlayingField());
        playingFields.put(secondPlayer, new ClassicalPlayingField());
    }

}
