public class PokerCard {

    private CardValue cardValue;
    private CardSuit cardSuit;

    public PokerCard(CardValue cardValue, CardSuit cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public CardSuit getCardSuit(){
        return cardSuit;
    }

    public CardValue getCardValue(){
        return cardValue;
    }
}
