package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {


    private final int WIDTH;
    private final int HEIGHT;
    private final int ROWS;
    private final int COLUMNS;
    private final int SLOT_WIDTH;
    private final int SLOT_HEIGHT;
    private final int START_INFO_RECT_WIDTH;
    private final int START_INFO_RECT_HEIGHT;
    private final int START_INFO_RECT_X_POSITION;
    private final int START_INFO_RECT_Y_POSITION;

    private JButton startButton = new JButton();
    private JLabel infoText = new JLabel();
    private JLabel infoTextPlayer1 = new JLabel();
    private JLabel infoTextPlayer2 = new JLabel();

    private boolean hasGameStart = false;

    public Panel(int rows, int columns) {
        this.setLayout(null);
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.WIDTH = columns * 100;
        this.HEIGHT = rows * 100;
        this.SLOT_WIDTH = WIDTH / COLUMNS;
        this.SLOT_HEIGHT = HEIGHT / ROWS;
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));

        this.START_INFO_RECT_WIDTH = WIDTH/2;
        this.START_INFO_RECT_HEIGHT = HEIGHT/2;
        this.START_INFO_RECT_X_POSITION = (WIDTH/2)-(START_INFO_RECT_WIDTH/2);
        this.START_INFO_RECT_Y_POSITION = (HEIGHT/2)-(START_INFO_RECT_HEIGHT/2);

        this.startButton.setText("Start");
        this.startButton.setSize(100, 50);
        this.startButton.setLocation((START_INFO_RECT_X_POSITION+(START_INFO_RECT_WIDTH/2)-(startButton.getWidth()/2)),
                (START_INFO_RECT_Y_POSITION*2)+(START_INFO_RECT_HEIGHT/3));
        this.startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hasGameStart = true;
                infoText.setVisible(false);
                infoTextPlayer1.setVisible(false);
                infoTextPlayer2.setVisible(false);
                startButton.setVisible(false);
                repaint();
                //startGame();
            }
        });
        this.add(startButton);

        this.infoText.setText("Free slots are empty and legal slots are green");
        this.infoText.setBounds(START_INFO_RECT_X_POSITION + 50,START_INFO_RECT_Y_POSITION,
                START_INFO_RECT_WIDTH - 50,START_INFO_RECT_HEIGHT/5);

        this.infoTextPlayer1.setText("logic.Player 1 color: Blue");
        this.infoTextPlayer1.setBounds(START_INFO_RECT_X_POSITION + 50,infoText.getY() + infoText.getHeight(),
                START_INFO_RECT_WIDTH - 50,START_INFO_RECT_HEIGHT/5);

        this.infoTextPlayer2.setText("logic.Player 2 color: Red");
        this.infoTextPlayer2.setBounds(START_INFO_RECT_X_POSITION + 50,infoTextPlayer1.getY() + infoTextPlayer1.getHeight(),
                START_INFO_RECT_WIDTH - 50,START_INFO_RECT_HEIGHT/5);

        this.add(infoText);
        this.add(infoTextPlayer1);
        this.add(infoTextPlayer2);
    }

    /*private void startGame() {
        repaint();
        //start logic
    }*/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(hasGameStart) {
            drawBoard(g);
        } else {
            drawStarGameInfo(g);
        }
    }

    private void drawBoard(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                g.drawRect(j * SLOT_WIDTH, i * SLOT_HEIGHT, SLOT_WIDTH, SLOT_HEIGHT);
            }
        }
    }

    private void drawStarGameInfo(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(START_INFO_RECT_X_POSITION, START_INFO_RECT_Y_POSITION, START_INFO_RECT_WIDTH, START_INFO_RECT_HEIGHT);

    }
}