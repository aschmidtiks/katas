package simulation;

import gui.Panel;
import logic.Cell;
import logic.World;

import java.util.Timer;
import java.util.TimerTask;

public class SimulationOnPanel {

    private int initialTickDelay = 1000;
    private int tickDelay = 500;

    private World world;
    private Panel panel;
    private Timer timer;

    public SimulationOnPanel(Cell[][] cellList, Panel panel) {
        System.out.println("START");
        this.panel = panel;
        world = new World(cellList);
        world.setNeighboursForAllCells();
        start(initialTickDelay, tickDelay);
    }

    public void restart(Cell[][] cellList) {
        System.out.println("RESTART");
        world.setCellList(cellList);
        world.setNeighboursForAllCells();
        start(initialTickDelay, tickDelay);
    }

    public void stop() {
        timer.cancel();
    }

    public void start(int initialDelay, int delay) {
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
        panel.paint();
        world.generateNextGeneration();
    }

}
