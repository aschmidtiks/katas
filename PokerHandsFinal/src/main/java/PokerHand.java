import java.util.ArrayList;
import java.util.*;
import java.util.Map;

public class PokerHand {

    private ArrayList<PokerCard> pokerCards;

    public PokerHand(ArrayList<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    public PokerRank pokerRank = new PokerRank(PokerRanking.HIGHCARD);

    public void checkHand() {
        NavigableMap<CardValue, Integer> cardMap = generateCardMap();
        if (isStraightFlush(cardMap)) {
            setRanking(PokerRanking.STRAIGHTFLUSH, cardMap);
        } else if (isFourOfAKind(cardMap)) {
            setRanking(PokerRanking.FOUROFAKIND, cardMap);
        } else if (isFullHouse(cardMap)) {
            setRanking(PokerRanking.FULLHOUSE, cardMap);
        } else if (isFlush()) {
            setRanking(PokerRanking.FLUSH, cardMap);
        } else if (isStraight(cardMap)) {
            setRanking(PokerRanking.STRAIGHT, cardMap);
        } else if (isThreeOfAKind(cardMap)) {
            setRanking(PokerRanking.THREEOFAKIND, cardMap);
        } else if (isTwoPairs(cardMap)) {
            setRanking(PokerRanking.TWOPAIRS, cardMap);
        } else if (isPair(cardMap)) {
            setRanking(PokerRanking.PAIR, cardMap);
        } else {
            setRanking(PokerRanking.HIGHCARD, cardMap);
        }
    }

    private NavigableMap<CardValue, Integer> generateCardMap() {
        NavigableMap<CardValue, Integer> cardMap = new TreeMap<CardValue, Integer>();
        for (PokerCard pokerCard : pokerCards) {
            if (cardMap.containsKey(pokerCard.getCardValue())) {
                int value = cardMap.get(pokerCard.getCardValue());
                value++;
                cardMap.put(pokerCard.getCardValue(), value);
            } else {
                cardMap.put(pokerCard.getCardValue(), 1);
            }
        }
        return cardMap.descendingMap();
    }

    private boolean isStraightFlush(NavigableMap<CardValue, Integer> cardMap) {
        return isFlush() && isStraight(cardMap);
    }

    private boolean isStraight(NavigableMap<CardValue, Integer> cardMap) {
        int straightCounter = 0;
        int prevStraightElement = 0;

        for (Map.Entry<CardValue, Integer> entry : cardMap.entrySet()) {
            if (prevStraightElement != 0 && (prevStraightElement - 1) == entry.getKey().value) {
                straightCounter++;
            }
            prevStraightElement = entry.getKey().value;
        }
        if (straightCounter == 3 && cardMap.firstEntry().getKey() == CardValue.ACE) {
            return cardMap.higherKey(cardMap.firstKey()).value == CardValue.FIVE.value;
        } else if ( straightCounter == 4) {
            return true;
        }
        return false;
    }

    private boolean isFlush() {
        for (int i = 1; i <= 4; i++) {
            if (!compareSuitForFlush(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareSuitForFlush(int suitPosition) {
        return pokerCards.get(0).getCardSuit().equals(pokerCards.get(suitPosition).getCardSuit());
    }

    private boolean isFourOfAKind(NavigableMap<CardValue, Integer> cardMap) {
        return cardMap.containsValue(4);
    }

    private boolean isFullHouse(NavigableMap<CardValue, Integer> cardMap) {
        return cardMap.containsValue(3) && cardMap.containsValue(2);
    }

    private boolean isThreeOfAKind(NavigableMap<CardValue, Integer> cardMap) {
        return cardMap.containsValue(3);
    }

    private boolean isTwoPairs(NavigableMap<CardValue, Integer> cardMap) {
        int pairCounter = 0;
        for (Map.Entry<CardValue, Integer> entry : cardMap.entrySet()) {
            if (entry.getValue() == 2) {
                pairCounter++;
            }
        }
        return pairCounter == 2;
    }

    private boolean isPair(NavigableMap<CardValue, Integer> cardMap) {
        return cardMap.containsValue(2);
    }

    private void setRanking(PokerRanking rank, NavigableMap<CardValue, Integer> cardMap) {
        pokerRank.setRank(rank);
        generateRankingList(rank, cardMap);
    }

    private void setNewRankingList(int cardFrequency, NavigableMap<CardValue, Integer> cardMap) {
        for (Map.Entry<CardValue, Integer> entry : cardMap.entrySet()) {
            if (entry.getValue() == cardFrequency) {
                for (int i = 0; i < cardFrequency; i++) {
                    pokerRank.tempPokerHand.add((entry.getKey().value));
                }
            }
        }
    }

    private void generateRankingList(PokerRanking rank, NavigableMap<CardValue, Integer> cardMap) {
        if (rank == PokerRanking.STRAIGHTFLUSH) {
            setNewRankingList(1, cardMap);
        } else if (rank == PokerRanking.FOUROFAKIND) {
            setNewRankingList(4, cardMap);
            setNewRankingList(1, cardMap);
        } else if (rank == PokerRanking.FULLHOUSE) {
            setNewRankingList(3, cardMap);
            setNewRankingList(2, cardMap);
        } else if (rank == PokerRanking.FLUSH) {
            setNewRankingList(1, cardMap);
        } else if (rank == PokerRanking.STRAIGHT) {
            setNewRankingList(1, cardMap);
        } else if (rank == PokerRanking.THREEOFAKIND) {
            setNewRankingList(3, cardMap);
            setNewRankingList(1, cardMap);
        } else if (rank == PokerRanking.TWOPAIRS) {
            setNewRankingList(2, cardMap);
            setNewRankingList(2, cardMap);
            setNewRankingList(1, cardMap);
        } else if (rank == PokerRanking.PAIR) {
            setNewRankingList(2, cardMap);
            setNewRankingList(1, cardMap);
        } else {
            setNewRankingList(1, cardMap);
        }
    }

}
