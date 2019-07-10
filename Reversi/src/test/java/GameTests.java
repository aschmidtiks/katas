import logic.Game;
import logic.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {

    @Test
    public void testIsPlayer1First(){
        Game game = new Game();
        assertEquals(Player.PLAYER1, game.getTurn().getCurrentPlayer());
    }

    @Test
    public void testFullMovesForPlayer1InFirstRound() {

        Game game = new Game();

        Point firstLegalMove3On3;
        firstLegalMove3On3 = new Point(5,3);
        Point secondLegalMove3On3;
        secondLegalMove3On3 = new Point(3,5);

        Point firstLegalMove4On4;
        firstLegalMove4On4 = new Point(4,2);
        Point secondLegalMove4On4;
        secondLegalMove4On4 = new Point(2,4);

        assertEquals(firstLegalMove3On3, game.getBoard().getLegalMovesList().get(0).get(0), "1.1");
        assertEquals(secondLegalMove3On3, game.getBoard().getLegalMovesList().get(1).get(0), "1.2");

        assertEquals(firstLegalMove4On4, game.getBoard().getLegalMovesList().get(2).get(0), "2.1");
        assertEquals(secondLegalMove4On4, game.getBoard().getLegalMovesList().get(3).get(0), "2.2");
    }

    @Test
    public void testFullMovesForPlayer2InFirstRound() {
        //Starting player needs to set to player2 | not going to happen in real game (player2 never uses the default board since player1 already places a disc)

        Game game = new Game();

        Point firstLegalMove3On3;
        firstLegalMove3On3 = new Point(2,3);
        Point secondLegalMove3On3;
        secondLegalMove3On3 = new Point(4,5);

        Point firstLegalMove4On4;
        firstLegalMove4On4 = new Point(3,2);
        Point secondLegalMove4On4;
        secondLegalMove4On4 = new Point(5,4);

        assertEquals(firstLegalMove3On3, game.getBoard().getLegalMovesList().get(0).get(0), "1.1");
        assertEquals(secondLegalMove3On3, game.getBoard().getLegalMovesList().get(1).get(0), "1.2");

        assertEquals(firstLegalMove4On4, game.getBoard().getLegalMovesList().get(2).get(0), "2.1");
        assertEquals(secondLegalMove4On4, game.getBoard().getLegalMovesList().get(3).get(0), "2.2");
    }



}
