import gui.Frame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SimulationWithSeed();
                //new SimulationOnPanel();
                new Frame(1000, 800, 100, 80);
            }
        });
    }
}
