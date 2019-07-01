import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    @Test
    void testAllHitNoStrikesAndSpares() {
        String rolls = "12345123451234512345";
        int result = 60;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }

    @Test
    void testOnlyStrikes() {
        String rolls = "XXXXXXXXXXXX";
        int result = 300;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }

    @Test
    void testAllNineAndZero() {
        String rolls = "9-9-9-9-9-9-9-9-9-9-";
        int result = 90;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }

    @Test
    void testAllSpares() {
        String rolls = "5/5/5/5/5/5/5/5/5/5/5";
        int result = 150;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }

    @Test
    void testStrikeAndSpare() {
        String rolls = "XXX5/XXXXXXXX";
        int result = 275;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }

    @Test
    void testStrikeAndNormalHits() {
        String rolls = "XXX52XXXXXXXX";
        int result = 259;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }

    @Test
    void testStrikeLastRound() {
        String rolls = "121212121212121212XXX";
        int result = 57;

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setRolls(rolls);
        bowlingGame.calculateScore();
        assertEquals(result, bowlingGame.getScore());
    }
}
