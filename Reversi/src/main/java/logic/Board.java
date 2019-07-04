package logic;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Board {

    private Slot[][] slots = new Slot[8][8];
    private static final int MAX_BOARD_SIZE = 8;
    public List<List<Point>> testLegalMoves = new ArrayList(MAX_BOARD_SIZE);
    private List<List<Point>> legalMoves = new ArrayList(MAX_BOARD_SIZE);

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

    public boolean calcLegalMoves(Player currentPlayer) {
        legalMoves.clear();
        for (int i = 0; i < MAX_BOARD_SIZE; i++) {
            for (int j = 0; j < MAX_BOARD_SIZE; j++) {
                if (slots[i][j].toString() == currentPlayer.toString()) {
                    calcLegalMovesForThisSlot(j, i, currentPlayer);
                }
            }
        }
        setSlotsForDrawFunction(currentPlayer);
        return true;
    }

    private void setSlotsForDrawFunction(Player currentPlayer) {
        if (currentPlayer.toString() == Player.PLAYER1.toString()) {
            for (int i = 0; i < legalMoves.size(); i++) {
                slots[legalMoves.get(i).get(0).y][legalMoves.get(i).get(0).x] = Slot.LEGAL_POSITION_P1;
            }
        } else {
            for (int i = 0; i < legalMoves.size(); i++) {
                slots[legalMoves.get(i).get(0).y][legalMoves.get(i).get(0).x] = Slot.LEGAL_POSITION_P2;
            }
        }
    }

    public void setSlotsForLogic() {
        for (int i = 0; i < legalMoves.size(); i++) {
            slots[legalMoves.get(i).get(0).y][legalMoves.get(i).get(0).x] = Slot.EMPTY;
        }
    }

    public List<List<Point>> getLegalMoves() {
        return legalMoves;
    }

    public void calcLegalMovesForThisSlot(int currentXPosition, int currentYPosition, Player currentPlayer) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && (slots[currentXPosition + j][currentYPosition + i].toString() != currentPlayer.toString()) &&
                        (slots[currentXPosition + j][currentYPosition + i].toString() != Slot.EMPTY.toString())) {
                    Point returnedPoint;
                    returnedPoint = calcLegalMovesForThisDirection(j, i, currentXPosition + j, currentYPosition + i, currentPlayer);
                    if (returnedPoint.x != MAX_BOARD_SIZE + 1 && returnedPoint.y != MAX_BOARD_SIZE + 1) {
                        List<Point> tempLegalMoveList = new ArrayList(3);
                        tempLegalMoveList.add(calcLegalMovesForThisDirection(j, i, currentXPosition + j, currentYPosition + i, currentPlayer));
                        tempLegalMoveList.add(new Point(j, i));
                        tempLegalMoveList.add(new Point(currentXPosition, currentYPosition));
                        legalMoves.add(tempLegalMoveList);
                    }
                }
            }
        }
        testLegalMoves.addAll(legalMoves);
    }

    public Point calcLegalMovesForThisDirection(int xDirection, int yDirection, int currentEnemyXPosition, int currentEnemyYPosition, Player currentPlayer) {
        Point enemyPosition = new Point(currentEnemyXPosition, currentEnemyYPosition);
        if (yDirection == -1) {
            return calcLegalMovesTop(xDirection, yDirection, enemyPosition, currentPlayer);
        } else if (yDirection == 0) {
            return calcLegalMovesSides(xDirection, yDirection, enemyPosition, currentPlayer);
        } else if (yDirection == 1) {
            return calcLegalMovesBottom(xDirection, yDirection, enemyPosition, currentPlayer);
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }

    private Point calcLegalMovesTop(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        switch (xDirection) {
            case -1: {
                Point tempPoint = calcLegalMovesTopLeft(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            case 0: {
                Point tempPoint = calcLegalMovesTopStraight(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            case 1: {
                Point tempPoint = calcLegalMovesTopRight(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            default:
                break;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesTopLeft(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                (enemyPosition.y + yDirection > 0 && enemyPosition.x + enemyPosition.x > 0)) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            yDirection += -1;
            xDirection += -1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesTopRight(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                (enemyPosition.y + yDirection > 0 && enemyPosition.x + enemyPosition.x < MAX_BOARD_SIZE)) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            yDirection += -1;
            xDirection += 1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesTopStraight(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                enemyPosition.y + yDirection > 0) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            yDirection += -1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }

    private Point calcLegalMovesSides(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        switch (xDirection) {
            case -1: {
                Point tempPoint = calcLegalMovesSidesLeft(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            case 0:
                break;
            case 1: {
                Point tempPoint = calcLegalMovesSidesRight(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            default:
                break;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesSidesLeft(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                enemyPosition.x + xDirection > 0) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            xDirection += -1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesSidesRight(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                enemyPosition.x + xDirection < MAX_BOARD_SIZE) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            xDirection += 1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }

    private Point calcLegalMovesBottom(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        switch (xDirection) {
            case -1: {
                Point tempPoint = calcLegalMovesBottomLeft(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            case 0: {
                Point tempPoint = calcLegalMovesBottomStraight(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            case 1: {
                Point tempPoint = calcLegalMovesBottomRight(xDirection, yDirection, enemyPosition, currentPlayer);
                if (tempPoint.x < MAX_BOARD_SIZE && tempPoint.y < MAX_BOARD_SIZE) {
                    return tempPoint;
                } else break;
            }
            default:
                break;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesBottomLeft(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                (enemyPosition.x + xDirection < MAX_BOARD_SIZE && enemyPosition.x + enemyPosition.x > 0)) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            yDirection += 1;
            xDirection += -1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesBottomStraight(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                enemyPosition.x + xDirection < MAX_BOARD_SIZE) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            yDirection += 1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }
    private Point calcLegalMovesBottomRight(int xDirection, int yDirection, Point enemyPosition, Player currentPlayer) {
        while (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection].toString() != currentPlayer.toString() ||
                (enemyPosition.x + xDirection < MAX_BOARD_SIZE && enemyPosition.x + enemyPosition.x < MAX_BOARD_SIZE)) {
            if (slots[enemyPosition.y + yDirection][enemyPosition.x + xDirection] == Slot.EMPTY) {
                return new Point(enemyPosition.x + xDirection, enemyPosition.y + yDirection);
            }
            yDirection += 1;
            xDirection += 1;
        }
        return new Point(MAX_BOARD_SIZE + 1, MAX_BOARD_SIZE + 1);
    }

    public Slot[][] getSlots() {
        return slots;
    }
    public void setSlot(Slot slotValue, int y, int x) {
        slots[y][x] = slotValue;
    }
}
