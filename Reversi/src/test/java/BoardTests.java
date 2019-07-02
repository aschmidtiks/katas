import logic.Board;
import logic.Slot;
import logic.Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTests {

    @Test
    public void testBlankBoard() {

        Slot[][] input = {
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
        };
        Slot[][] result = {
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
        };

        Board board = new Board(input);
        Game game = new Game(board);
        assertArrayEquals(result, board.getSlots());
    }

    @Test
    public void testDefaultBoard() {

        Slot[][] input = {
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER1, Slot.PLAYER2, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER2, Slot.PLAYER1, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
        };
        Slot[][] result = {
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P1, Slot.LEGAL_POSITION_P2, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P1, Slot.PLAYER1, Slot.PLAYER2, Slot.LEGAL_POSITION_P2, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P2, Slot.PLAYER2, Slot.PLAYER1, Slot.LEGAL_POSITION_P1, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P2, Slot.LEGAL_POSITION_P1, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
        };

        Board board = new Board(input);
        Game game = new Game(board);

        board.setSlot(Slot.LEGAL_POSITION_P1, 2, 3);
        board.setSlot(Slot.LEGAL_POSITION_P1, 3, 2);
        board.setSlot(Slot.LEGAL_POSITION_P1, 4, 5);
        board.setSlot(Slot.LEGAL_POSITION_P1, 5, 4);

        board.setSlot(Slot.LEGAL_POSITION_P2, 2, 4);
        board.setSlot(Slot.LEGAL_POSITION_P2, 3, 5);
        board.setSlot(Slot.LEGAL_POSITION_P2, 4, 2);
        board.setSlot(Slot.LEGAL_POSITION_P2, 5, 3);
        assertArrayEquals(result, board.getSlots());
    }

    @Test
    public void testPlayer1FirstRound() {

        Slot[][] input = {
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER1, Slot.PLAYER2, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER2, Slot.PLAYER1, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
        };
        Slot[][] result = {
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P1, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P1, Slot.PLAYER1, Slot.PLAYER2, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.PLAYER2, Slot.PLAYER1, Slot.LEGAL_POSITION_P1, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.LEGAL_POSITION_P1, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
                {Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY, Slot.EMPTY},
        };

        Board board = new Board(input);
        Game game = new Game(board);

        board.setSlot(Slot.LEGAL_POSITION_P1, 2, 3);
        board.setSlot(Slot.LEGAL_POSITION_P1, 3, 2);
        board.setSlot(Slot.LEGAL_POSITION_P1, 4, 5);
        board.setSlot(Slot.LEGAL_POSITION_P1, 5, 4);

        assertArrayEquals(result, board.getSlots());
    }
}
