import logic.Game;
import logic.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {

    @Test
    public void testIsPlayer1First(){
        Game game = new Game();
        assertEquals(Player.PLAYER1, game.getTurn().getCurrentPlayer());
    }


}
