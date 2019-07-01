import java.util.ArrayList;

public class PokerGame {

    public PokerGame(){
        initPokerGame();
    }

    public void initPokerGame() {
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

        playHands(playerHands);
        compareHands(playerHands);
    }

    public void playHands(ArrayList<PokerHand> playerHand) {
        for(int i = 0; i < playerHand.size(); i++) {
            playerHand.get(i).checkHand();
        }
    }

    public String compareHands(ArrayList<PokerHand> playerHand) {
        //TODO: sort playerHand while comparing if more than 2 player
        for(int i = 0; i < playerHand.size()-1; i++) {
            if (playerHand.get(i).pokerRank.getRank().rank > playerHand.get(i + 1).pokerRank.getRank().rank) {
                return "player1";
            } else if (playerHand.get(i).pokerRank.getRank().rank < playerHand.get(i + 1).pokerRank.getRank().rank) {
                return "player2";
            } else if (playerHand.get(i).pokerRank.getRank().rank == playerHand.get(i + 1).pokerRank.getRank().rank) {
                //check with newRankList
                return compareEqualRankedHands(playerHand);
            }
        }
        return "DRAW";
    }

    public String compareEqualRankedHands(ArrayList<PokerHand> playerHand) {
        for(int i = 0; i < playerHand.size()-1; i++) {
            for(int j = 0; j < 5; j++) {
                return playerHand.get(0).pokerRank.tempPokerHand.get(j) > playerHand.get(1).pokerRank.tempPokerHand.get(j) ? "player1" : "player2";
            }
        }
        return "DRAW";
    }
}
