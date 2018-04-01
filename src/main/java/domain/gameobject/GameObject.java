package domain.gameobject;

import domain.gameobject.gameobjectpart.GameObjectPart;

import java.util.ArrayList;

public interface GameObject {
    public int getSize();

    public Status getStatus();

    public void changeStatus();

    public Kind getKind();

    public ArrayList<GameObjectPart> getAllParts();
}
