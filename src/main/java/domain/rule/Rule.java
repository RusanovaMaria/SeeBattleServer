package domain.rule;

import domain.GameObject.Kind;

public interface Rule {

    int[] getGameObjectsSize();

    int countQuantityOfObjects(Kind kind);
}
