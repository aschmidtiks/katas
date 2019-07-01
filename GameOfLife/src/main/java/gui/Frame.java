package gui;

import javax.swing.*;

public class Frame extends JFrame {

    private Panel mainPanel;

    public Frame(int width, int height, int columns, int rows) {
        this.setTitle("Game Of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(0,0);

        mainPanel = new Panel(width,height, rows, columns);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public Panel getPanel() {
        return mainPanel;
    }
}
