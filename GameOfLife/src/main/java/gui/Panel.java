package gui;

import logic.Cell;
import logic.World;
import simulation.SimulationOnPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel {

    private final int ROWS;
    private final int COLUMNS;
    private final int HEIGHT_OF_ROWS;
    private final int WIDTH_OF_ROWS;

    private Cell[][] cellList;
    private Cell[][] tempCellList;
    private boolean allowMouseInput = true;
    private boolean isFreshStart = true;
    private boolean isSimInProgress = false;
    private SimulationOnPanel simulation;

    public Panel(int width, int height, int rows, int columns) {
        this.setFocusable(true);
        this.cellList = World.generateCellList(rows, columns);
        this.tempCellList = new Cell[cellList.length][cellList[0].length];
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.HEIGHT_OF_ROWS = height / ROWS;
        this.WIDTH_OF_ROWS = width / COLUMNS;
        setPreferredSize(new Dimension(width, height));
        addListeners();
    }

    private void addListeners() {
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && allowMouseInput) {
                    int x, y;
                    x = e.getX();
                    y = e.getY();
                    cellList[y / HEIGHT_OF_ROWS][x / WIDTH_OF_ROWS].setAlive(!cellList[y / HEIGHT_OF_ROWS][x / WIDTH_OF_ROWS].isAlive());
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

        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32 && !isSimInProgress) { //32 = Spacebar
                    if (isFreshStart) {
                        tempCellList = copyOfCellList();
                        simulation = new SimulationOnPanel(cellList, Panel.this);
                        isSimInProgress = true;
                        allowMouseInput = false;
                        isFreshStart = false;
                    } else {
                        simulation.restart(tempCellList);
                        //simulation = new SimulationOnPanel(tempCellList, Panel.this);
                        isSimInProgress = true;
                        allowMouseInput = false;
                    }
                } else if (e.getKeyCode() == 27 && isSimInProgress) { //27 = Escape
                    isSimInProgress = false;
                    allowMouseInput = true;

                    simulation.stop();
                }
            }
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCells(g);
    }

    private void drawCells(Graphics g) {
        for (int i = 1; i < ROWS - 1; i++) {
            for (int j = 1; j < COLUMNS - 1; j++) {
                if (!cellList[i][j].isAlive()) {
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

    public Cell[][] copyOfCellList() {
        Cell[][] tempListCell = new Cell[cellList.length][cellList[0].length];
        tempListCell = getCellList();
        for (int i = 0; i < cellList.length; i++) {
            for (int j = 0; j < cellList[0].length; j++) {
                tempListCell[i][j] = cellList[i][j];
            }
        }
        return tempListCell;
    }
    public Cell[][] getCellList() {
        return cellList;
    }

}
