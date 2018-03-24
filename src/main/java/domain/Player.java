package domain;

public interface Player {
    String getName();
    Result action(Cell cell);
}
