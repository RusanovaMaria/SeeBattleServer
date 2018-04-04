package domain.gameobject;

import domain.gameobject.gameobjectpart.GameObjectPart;

import java.util.ArrayList;

public interface GameObject {
     int getSize();

     Status getStatus();

     void changeStatus();

     Kind getKind();

     ArrayList<GameObjectPart> getAllParts();
}
