package gui;

import simulation.SimulationWithManualInputs;
import simulation.SimulationWithSeed;
import logic.World;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static sun.java2d.cmm.ColorTransform.Simulation;

public class Frame extends JFrame {

    private Panel mainPanel;
    private SimulationWithManualInputs simulation;

    public Frame(int width, int height, int rows, int columns, World world, SimulationWithManualInputs sim) {
        this.simulation = sim;

        this.setTitle("Game Of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(0,0);

        mainPanel = new Panel(width,height, rows, columns, world);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);

        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==32) { //32 = Spacebar
                    simulation.startSimulation();

                }
            }
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public Frame(int width, int height, int rows, int columns, World world) {
        this.setTitle("Game Of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(0,0);

        mainPanel = new Panel(width,height, rows, columns, world);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public Panel getPanel() {
        return mainPanel;
    }
}
