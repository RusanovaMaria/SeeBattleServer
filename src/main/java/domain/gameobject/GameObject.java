package domain.gameobject;

public interface GameObject {
    public int getSize();
    public Status getStatus();
    public void changeStatus();
}
