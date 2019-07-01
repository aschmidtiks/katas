import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class PokerGameTest {

    @Test
    public void Player2WinsWith2PairAndHighcard() {
        PokerCard pokerCardPlayer11 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCardPlayer12 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCardPlayer13 = new PokerCard(CardValue.FIVE, CardSuit.SPADES);
        PokerCard pokerCardPlayer14 = new PokerCard(CardValue.TWO, CardSuit.CLUBS);
        PokerCard pokerCardPlayer15 = new PokerCard(CardValue.FOUR, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCardsPlayer1 = new ArrayList<PokerCard>();

        pokerCardsPlayer1.add(pokerCardPlayer11);
        pokerCardsPlayer1.add(pokerCardPlayer12);
        pokerCardsPlayer1.add(pokerCardPlayer13);
        pokerCardsPlayer1.add(pokerCardPlayer14);
        pokerCardsPlayer1.add(pokerCardPlayer15);

        PokerHand pokerHandPlayer1 = new PokerHand(pokerCardsPlayer1);

        //---------------------player2----------------------

        PokerCard pokerCardPlayer21 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCardPlayer22 = new PokerCard(CardValue.TEN, CardSuit.CLUBS);
        PokerCard pokerCardPlayer23 = new PokerCard(CardValue.FIVE, CardSuit.SPADES);
        PokerCard pokerCardPlayer24 = new PokerCard(CardValue.TWO, CardSuit.CLUBS);
        PokerCard pokerCardPlayer25 = new PokerCard(CardValue.FOUR, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCardsPlayer2 = new ArrayList<PokerCard>();

        pokerCardsPlayer2.add(pokerCardPlayer21);
        pokerCardsPlayer2.add(pokerCardPlayer22);
        pokerCardsPlayer2.add(pokerCardPlayer23);
        pokerCardsPlayer2.add(pokerCardPlayer24);
        pokerCardsPlayer2.add(pokerCardPlayer25);

        PokerHand pokerHandPlayer2 = new PokerHand(pokerCardsPlayer2);

        ArrayList<PokerHand> playerHands = new ArrayList<PokerHand>();
        playerHands.add(pokerHandPlayer1);
        playerHands.add(pokerHandPlayer2);

        PokerGame game = new PokerGame();
        game.playHands(playerHands);

        assertEquals("player2", game.compareHands(playerHands));
    }

    @Test
    public void Player2WinsWithTwoPairs() {
        PokerCard pokerCardPlayer11 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCardPlayer12 = new PokerCard(CardValue.TWO, CardSuit.CLUBS);
        PokerCard pokerCardPlayer13 = new PokerCard(CardValue.THREE, CardSuit.SPADES);
        PokerCard pokerCardPlayer14 = new PokerCard(CardValue.THREE, CardSuit.CLUBS);
        PokerCard pokerCardPlayer15 = new PokerCard(CardValue.QUEEN, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCardsPlayer1 = new ArrayList<PokerCard>();

        pokerCardsPlayer1.add(pokerCardPlayer11);
        pokerCardsPlayer1.add(pokerCardPlayer12);
        pokerCardsPlayer1.add(pokerCardPlayer13);
        pokerCardsPlayer1.add(pokerCardPlayer14);
        pokerCardsPlayer1.add(pokerCardPlayer15);

        PokerHand pokerHandPlayer1 = new PokerHand(pokerCardsPlayer1);

        //---------------------player2----------------------

        PokerCard pokerCardPlayer21 = new PokerCard(CardValue.THREE, CardSuit.HEARTS);
        PokerCard pokerCardPlayer22 = new PokerCard(CardValue.THREE, CardSuit.CLUBS);
        PokerCard pokerCardPlayer23 = new PokerCard(CardValue.FOUR, CardSuit.SPADES);
        PokerCard pokerCardPlayer24 = new PokerCard(CardValue.FOUR, CardSuit.CLUBS);
        PokerCard pokerCardPlayer25 = new PokerCard(CardValue.JACK, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCardsPlayer2 = new ArrayList<PokerCard>();

        pokerCardsPlayer2.add(pokerCardPlayer21);
        pokerCardsPlayer2.add(pokerCardPlayer22);
        pokerCardsPlayer2.add(pokerCardPlayer23);
        pokerCardsPlayer2.add(pokerCardPlayer24);
        pokerCardsPlayer2.add(pokerCardPlayer25);

        PokerHand pokerHandPlayer2 = new PokerHand(pokerCardsPlayer2);

        ArrayList<PokerHand> playerHands = new ArrayList<PokerHand>();
        playerHands.add(pokerHandPlayer1);
        playerHands.add(pokerHandPlayer2);

        PokerGame game = new PokerGame();
        game.playHands(playerHands);

        assertEquals("player2", game.compareHands(playerHands));
    }
}
