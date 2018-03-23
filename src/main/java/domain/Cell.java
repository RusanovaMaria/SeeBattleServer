package domain;

public class Cell {
    private CellStatus status;

    Cell(CellStatus status){
        this.status = status;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setValue(CellStatus status){
        this.status = status;
    }

    public void mark(){
        status = CellStatus.MARKED;
    }
}
