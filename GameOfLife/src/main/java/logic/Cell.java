package logic;

public class Cell {

    private boolean isAlive = false;
    private int aliveNeighbours;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Cell() {
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getAliveNeighbours() {
        return aliveNeighbours;
    }

    public void setAliveNeighbours(int aliveNeighbours) {
        this.aliveNeighbours = aliveNeighbours;
    }

}
