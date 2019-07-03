package logic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private Slot[][] slots = new Slot[8][8];

    private Slot[][] defaultBoard = {
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER1, Slot.PLAYER2, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER2, Slot.PLAYER1, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
            {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},

    };

    public Board() {
        for (int i = 0; i < slots.length; i++) {
            for (int j = 0; j < slots[0].length; j++) {
                this.slots[i][j] = defaultBoard[i][j];
            }
        }
    }
    public Board(Slot[][] slots) {
        for (int i = 0; i < slots.length; i++) {
            for (int j = 0; j < slots[0].length; j++) {
                this.slots[i][j] = slots[i][j];
            }
        }
    }

    public void calcLegalMoves(Player currentPlayer) {
        if (currentPlayer == Player.PLAYER1) {
            for (int i = 0; i < slots.length; i++) {
                for (int j = 0; j < slots[0].length; j++) {
                    if (slots[i][j] == Slot.PLAYER1) {
                        calcLegalMovesForThisSlot(i, j, currentPlayer);
                    }
                }
            }
        } /*else if(currentPlayer == Player.PLAYER2) {
            for (int i = 0; i < slots.length; i++) {
                for (int j = 0; j < slots[0].length; j++) {
                    if (slots[i][j] == Slot.PLAYER2) {

                    }
                }
            }
        }*/
    }

    private void calcLegalMovesForThisSlot(int currentYPosition, int currentXPosition, Player currentPlayer) {
        List<Point> legalMoves = new ArrayList<Point>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    switch (currentPlayer) {
                        case PLAYER1: {
                            if (slots[currentYPosition + i][currentXPosition + j] == Slot.PLAYER2) {
                                legalMoves.add(calcLegalMovesForThisDirection(i, j,currentYPosition + i, currentXPosition + j));
                            }
                            break;
                        }
                        case PLAYER2: {
                            if (slots[currentYPosition + i][currentXPosition + j] == Slot.PLAYER1) {
                                legalMoves.add(calcLegalMovesForThisDirection(i, j, currentYPosition + i, currentXPosition + j));
                            }
                            break;
                        }
                    }
                }
            }
        }

    }

    private Point calcLegalMovesForThisDirection(int yDirection, int xDirection, int currentEnemyYPosition, int currentEnemyXPosition) {
        Point direction = new Point(yDirection, xDirection);
        boolean foundLegalMove = false;
        while (foundLegalMove == false)
        {
            //TODO sldkfjsdfj
            switch (direction)
            {

            }
            /*
              if (slots[yDirection+yDirection][xDirection+xDirection] == Slot.EMPTY) {
                    //foundLegalMove = true;
                    return new Point(yDirection, xDirection);
                }
             */
        }
        return new Point(0, 0);
    }

    public Slot[][] getSlots() {
        return slots;
    }

    public void setSlot(Slot slotValue, int y, int x) {
        slots[y][x] = slotValue;
    }
}
