package simulation;

import gui.Frame;
import logic.Cell;
import logic.World;
import simulation.SimulationInterface;

import java.util.Timer;
import java.util.TimerTask;

public class SimulationWithSeed implements SimulationInterface {

    private int initialTickDelay = 1000;
    private int tickDelay = 500;

    private World world;
    private Frame frame;

    public SimulationWithSeed() {
        initSimulation();
    }

    public void initSimulation() {
        String newSeed =
                "00000000000000000000000000000000000000-" +
                        "00000000000000000000000001000000000000-" +
                        "00000000000000000000000101000000000000-" +
                        "00000000000001100000011000000000000110-" +
                        "00000000000010001000011000000000000110-" +
                        "01100000000100000100011000000000000000-" +
                        "01100000000100010110000101000000000000-" +
                        "00000000000100000100000001000000000000-" +
                        "00000000000010001000000000000000000000-" +
                        "00000000000001100000000000000000000000-" +
                        "00000000000000000000000000000000000000";

        world = new World(38, 11, newSeed);
        frame = new Frame(380, 110, 11, 38, world);
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
        //world.outputWorldInConsole(); //console output only
        frame.getPanel().paint();
        world.generateNextGeneration();
    }
}
