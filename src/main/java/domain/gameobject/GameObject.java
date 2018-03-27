package domain.gameobject;

import domain.gameobject.gameobjectpart.GameObjectPart;

import java.util.ArrayList;

public interface GameObject {
    public int getSize();
    public Status getStatus();
    public Kind getKind();
    public void changeStatus();
    public ArrayList<GameObjectPart> getAllParts();
}
