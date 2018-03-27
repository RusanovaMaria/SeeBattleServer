package domain.rule;

import domain.gameobject.Kind;

import java.util.HashMap;
import java.util.Map;

public class ClassicRule implements Rule {

    private int[] gameObjectsSize = {1, 2, 3, 4};
    private Map<Kind, Integer> numOfGameObjects;


    public ClassicRule() {
        initNumOfGameObjects();
    }

    @Override
    public int[] getGameObjectsSize() {
        return gameObjectsSize;
    }

    @Override
    public int countNumberOfObjects(Kind kind) {
        int number = numOfGameObjects.get(kind);
        return number;
    }

    private void initNumOfGameObjects() {

        numOfGameObjects = new HashMap<>();

        numOfGameObjects.put(Kind.SINGLE_DECKED, 4);
        numOfGameObjects.put(Kind.DOUBLE_DECKED, 3);
        numOfGameObjects.put(Kind.THREE_DECKED, 2);
        numOfGameObjects.put(Kind.FOUR_DECKED, 1);
    }
}
