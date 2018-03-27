package domain.rule;

import domain.gameobject.Kind;

public interface Rule {

    public int [] getGameObjectsSize();
    public int countNumberOfObjects(Kind kind);

}
