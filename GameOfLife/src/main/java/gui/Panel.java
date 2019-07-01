package gui;

import logic.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel {

    private final int ROWS;
    private final int COLUMNS;
    private final int HEIGHT_OF_ROWS;
    private final int WIDTH_OF_ROWS;
    private boolean allowMouseInput = true;

    private World newWorld;

    public Panel(int width, int height, int rows, int columns, World world) {
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.newWorld = world;
        this.HEIGHT_OF_ROWS = height / ROWS;
        this.WIDTH_OF_ROWS = width / COLUMNS;
        setPreferredSize(new Dimension(width, height));

        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1 && allowMouseInput) {
                    int x, y;
                    x = e.getX();
                    y = e.getY();
                    newWorld.getCellList()[y / 10][x / 10].setAlive(true);
                    repaint();
                }
            }
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCells(g, newWorld);
    }

    private void drawCells(Graphics g, World world) {
        for (int i = 1; i < ROWS-1; i++) {
            for (int j = 1; j < COLUMNS-1; j++) {
                if(!world.getCellList()[i][j].isAlive()) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * WIDTH_OF_ROWS, i * HEIGHT_OF_ROWS, WIDTH_OF_ROWS, HEIGHT_OF_ROWS);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * WIDTH_OF_ROWS, i * HEIGHT_OF_ROWS, WIDTH_OF_ROWS, HEIGHT_OF_ROWS);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * WIDTH_OF_ROWS, i * HEIGHT_OF_ROWS, WIDTH_OF_ROWS, HEIGHT_OF_ROWS);
                    g.drawRect(j * WIDTH_OF_ROWS, i * HEIGHT_OF_ROWS, WIDTH_OF_ROWS, HEIGHT_OF_ROWS);
                }
            }
        }
    }

    public void paint() {
        repaint();
    }

}
