package domain.GameObject;

public interface GameObject {

    void shoot();

    Kind getKind();

    int getSize();

    Status getStatus();
}
