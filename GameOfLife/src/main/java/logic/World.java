package logic;

public class World {

    private Cell[][] cellList;
    private int cellsPerColumn;
    private int cellsPerRow;

    //constructor for wold with seed
    public World(int cellsPerRow, int cellsPerColumn, String seed) {
        this.cellsPerColumn = cellsPerColumn;
        this.cellsPerRow = cellsPerRow;
        initCells(cellsPerRow, cellsPerColumn, seed);
    }
    private void initCells(int cellsPerRow, int cellsPerColumn, String seed) {
        Cell[][] tempListCell;
        tempListCell = fillWorldWithCells(cellsPerRow, cellsPerColumn, seed);
        setNeighboursForAllCells(tempListCell);
    }
    private Cell[][] fillWorldWithCells(int cellsPerRow, int cellsPerColumn, String seed) {
        Cell[][] tempListCell = new Cell[cellsPerColumn][cellsPerRow];
        String[] transformedSeed = seed.split("[-]");
        for (int y = 0; y < transformedSeed.length; y++) {
            for (int x = 0; x < transformedSeed[y].length(); x++) {
                tempListCell[y][x] = new Cell("1".equals(transformedSeed[y].substring(x, x + 1)));
            }
        }
        return tempListCell;
    }

    //constructor for manual world
    public World(Cell[][] cellList) {
        this.cellsPerColumn = cellList.length;
        this.cellsPerRow = cellList[0].length;
        setCellList(cellList);
        //this.setNeighboursForAllCells(cellList);
    }

    private void setCellList(Cell[][] tempListCell) {
        this.cellList = tempListCell;
    }

    public Cell[][] getCellList() {
        return cellList;
    }

    public void outputWorldInConsole() {
        for (int y = 1; y < cellsPerColumn - 1; y++) {
            for (int x = 1; x < cellsPerRow - 1; x++) {
                if (cellList[y][x] != null) {
                    int cellValue = cellList[y][x].isAlive() ? 1 : 0;
                    if (cellValue == 0) {
                        System.out.print("\033[31;1m" + cellValue + " ");
                    } else {
                        System.out.print("\033[32;1m" + cellValue + " ");
                    }
                }
            }
            System.out.println("\033[30;1m");
        }
        System.out.println();
        System.out.println();
    }

    public void generateNextGeneration() {
        Cell[][] cellList = getCellList();
        Cell[][] tempListCell = new Cell[cellList.length][cellList[0].length];
        copyOfCellList(tempListCell);

        for (int y = 1; y < cellsPerColumn - 1; y++) {
            for (int x = 1; x < cellsPerRow - 1; x++) {
                Cell cell = cellList[y][x];
                if (cell.isAlive() && cell.getAliveNeighbours() < 2 ||
                        cell.isAlive() && cell.getAliveNeighbours() > 3) {
                    tempListCell[y][x].setAlive(false);
                } else if (cell.isAlive() && cell.getAliveNeighbours() == 2 ||
                        cell.isAlive() && cell.getAliveNeighbours() == 3) {
                    tempListCell[y][x].setAlive(true);
                } else if (!cell.isAlive() && cell.getAliveNeighbours() == 3) {
                    tempListCell[y][x].setAlive(true);
                }
            }
        }
        setNeighboursForAllCells();
    }

    private void copyOfCellList(Cell[][] tempListCell) {
        for (int i = 0; i < cellList.length; i++) {
            for (int j = 0; j < cellList[0].length; j++) {
                tempListCell[i][j] = cellList[i][j];
            }
        }
    }

    public void setNeighboursForAllCells() {
        Cell[][] tempListCell = getCellList();
        for (int y = 1; y < cellsPerColumn - 1; y++) {
            for (int x = 1; x < cellsPerRow - 1; x++) {
                int neighbours = countNeighbours(tempListCell, y, x);
                tempListCell[y][x].setAliveNeighbours(neighbours);
            }
        }
        setCellList(tempListCell);
    }

    public void setNeighboursForAllCells(Cell[][] tempListCell) {
        for (int y = 1; y < cellsPerColumn - 1; y++) {
            for (int x = 1; x < cellsPerRow - 1; x++) {
                int neighbours = countNeighbours(tempListCell, y, x);
                tempListCell[y][x].setAliveNeighbours(neighbours);
            }
        }
        setCellList(tempListCell);
    }

    public int countNeighbours(Cell[][] cells, int xPosition, int yPosition) {
        int tempNeighbourCounter = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    tempNeighbourCounter += cells[xPosition + i][yPosition + j].isAlive() ? 1 : 0;
                }
            }
        }
        return tempNeighbourCounter;
    }

    public static Cell[][] generateCellList(int cellsPerColumn, int cellsPerRow) {
        Cell[][] tempListCell = new Cell[cellsPerColumn][cellsPerRow];
        for (int y = 0; y < cellsPerColumn; y++) {
            for (int x = 0; x < cellsPerRow; x++) {
                tempListCell[y][x] = new Cell();
            }
        }
        return tempListCell;
    }
}