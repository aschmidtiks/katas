package simulation;

import gui.Frame;
import logic.Cell;
import logic.World;

import java.util.Timer;
import java.util.TimerTask;

public class SimulationWithManualInputs {

    private int initialTickDelay = 1000;
    private int tickDelay = 500;

    private World world;
    private Frame frame;
    private Cell[][] cellList;

    public SimulationWithManualInputs() {
        initSimulation();
    }

    public void initSimulation() {
        int cellsPerRow = 100;
        int cellsPerColumn = 80;
        int width = 1000;
        int height = 800;
        cellList = World.generateCellList(cellsPerColumn,cellsPerRow);
        world = new World(cellList);
        frame = new Frame(width, height, cellsPerColumn, cellsPerRow, world, this);
    }

    public void startSimulation() {
        world.setNeighboursForAllCells();
        startTimer(initialTickDelay, tickDelay);
    }

    public void startTimer(int initialDelay, int delay) {
        Timer timer;
        TimerTask timedTask;
        timedTask = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timedTask, initialDelay, delay);
    }

    public void tick() {
        frame.getPanel().paint();
        world.generateNextGeneration();
    }
}
