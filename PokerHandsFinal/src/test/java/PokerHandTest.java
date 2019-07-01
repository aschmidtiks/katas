import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class PokerHandTest {

    @Test
    public void testHighCard(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.FIVE, CardSuit.SPADES);
        PokerCard pokerCard4 = new PokerCard(CardValue.TEN, CardSuit.CLUBS);
        PokerCard pokerCard5 = new PokerCard(CardValue.FOUR, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.HIGHCARD, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testPair(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.FIVE, CardSuit.SPADES);
        PokerCard pokerCard4 = new PokerCard(CardValue.TWO, CardSuit.CLUBS);
        PokerCard pokerCard5 = new PokerCard(CardValue.FOUR, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.PAIR, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testTwoPair(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.EIGHT, CardSuit.SPADES);
        PokerCard pokerCard4 = new PokerCard(CardValue.TWO, CardSuit.CLUBS);
        PokerCard pokerCard5 = new PokerCard(CardValue.FOUR, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.TWOPAIRS, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testThreeOfAKind(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.EIGHT, CardSuit.SPADES);
        PokerCard pokerCard4 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCard5 = new PokerCard(CardValue.FOUR, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.THREEOFAKIND, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testStraight(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.THREE, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.FIVE, CardSuit.SPADES);
        PokerCard pokerCard4 = new PokerCard(CardValue.FOUR, CardSuit.CLUBS);
        PokerCard pokerCard5 = new PokerCard(CardValue.SIX, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.STRAIGHT, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testFlush(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.HEARTS);
        PokerCard pokerCard3 = new PokerCard(CardValue.EIGHT, CardSuit.HEARTS);
        PokerCard pokerCard4 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard5 = new PokerCard(CardValue.FOUR, CardSuit.HEARTS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.FLUSH, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testFullHouse(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.DIAMONDS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.EIGHT, CardSuit.HEARTS);
        PokerCard pokerCard4 = new PokerCard(CardValue.TWO, CardSuit.DIAMONDS);
        PokerCard pokerCard5 = new PokerCard(CardValue.TWO, CardSuit.SPADES);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.FULLHOUSE, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testFourOfAKind(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.DIAMONDS);
        PokerCard pokerCard2 = new PokerCard(CardValue.EIGHT, CardSuit.HEARTS);
        PokerCard pokerCard3 = new PokerCard(CardValue.TWO, CardSuit.CLUBS);
        PokerCard pokerCard4 = new PokerCard(CardValue.TWO, CardSuit.DIAMONDS);
        PokerCard pokerCard5 = new PokerCard(CardValue.TWO, CardSuit.SPADES);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.FOUROFAKIND, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testStraightFlush(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.THREE, CardSuit.HEARTS);
        PokerCard pokerCard3 = new PokerCard(CardValue.FOUR, CardSuit.HEARTS);
        PokerCard pokerCard4 = new PokerCard(CardValue.FIVE, CardSuit.HEARTS);
        PokerCard pokerCard5 = new PokerCard(CardValue.SIX, CardSuit.HEARTS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.STRAIGHTFLUSH, pokerHand.pokerRank.getRank());
    }

    @Test
    public void testStraight2(){
        PokerCard pokerCard1 = new PokerCard(CardValue.TWO, CardSuit.HEARTS);
        PokerCard pokerCard2 = new PokerCard(CardValue.THREE, CardSuit.CLUBS);
        PokerCard pokerCard3 = new PokerCard(CardValue.FIVE, CardSuit.SPADES);
        PokerCard pokerCard4 = new PokerCard(CardValue.FOUR, CardSuit.CLUBS);
        PokerCard pokerCard5 = new PokerCard(CardValue.ACE, CardSuit.DIAMONDS);

        ArrayList<PokerCard> pokerCards = new ArrayList<PokerCard>();

        pokerCards.add(pokerCard1);
        pokerCards.add(pokerCard2);
        pokerCards.add(pokerCard3);
        pokerCards.add(pokerCard4);
        pokerCards.add(pokerCard5);

        PokerHand pokerHand = new PokerHand(pokerCards);

        pokerHand.checkHand();
        assertEquals(PokerRanking.STRAIGHT, pokerHand.pokerRank.getRank());
    }
}
