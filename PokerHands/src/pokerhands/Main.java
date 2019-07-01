package pokerhands;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    /*
    Ranking:
    high card = 1, Pair = 2, two pair = 3, three of a kind = 4, straight = 5, flush = 6, full house = 7, four of a kind = 8, straight flush = 9
     */
    private String initialInput = "2H3D2S9CKD 2C3H4S8CAH";  //"2H3D2S9CKD2C3H4S8CAH"   //"2H 3D 5S 9C KD 2C 3H 4S 8C AH";  //"2H3D5S9CKD2C3H4S8CAH"
    private ArrayList<String> listhandPlayer1 = new ArrayList();    //2H 3D 2S 9C KD
    private ArrayList<String> numericOnlyHandPlayer1 = new ArrayList(); //2H 3D 2S 9C 13D
    private ArrayList<String> listhandPlayer2 = new ArrayList();    //2C 3H 4S 8C AH
    private ArrayList<String> numericOnlyHandPlayer2 = new ArrayList(); //2C 3H 4S 8C 14H

    private static final int PLAYER1CARDS = 10, PLAYER2CARDS = 20;

    //private int[] flushCounter = new int[2];
    private String[] highCard = new String[2];
    private int[] handRank = new int[2];

    public Main() {
        getHands();
        checkHands();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    public void getHands() {
        initialInput = initialInput.replaceAll("\\s+", "");
        for (int i = 0; i < PLAYER1CARDS; i += 2) {
            listhandPlayer1.add(initialInput.substring(i, i + 2));
        }
        for (int i = 10; i < PLAYER2CARDS; i += 2) {
            listhandPlayer2.add(initialInput.substring(i, i + 2));
        }
    }

    public void checkHands() {

        transformToNumericOnlyHand(listhandPlayer1, listhandPlayer2);
        sortHandsAscending(numericOnlyHandPlayer1, numericOnlyHandPlayer2);



        if (isFlush(listhandPlayer1)) {
            //check straight flush, FOAK, full House
        } else {
            isStraight(numericOnlyHandPlayer1);
            //check straight, TOAK, two pairs, pair, highcard
        }
    }

    public String checkHighCard(ArrayList<String> hand) {
        int[] numericTranslation = new int[5];
        int indexCounter = 0;

        for (Iterator<String> it = hand.iterator(); it.hasNext(); ) {
            String handIterator = it.next();
            if (handIterator.substring(0, 1).equals("T")) {
                numericTranslation[indexCounter] = 10;
                indexCounter++;
            } else if (handIterator.substring(0, 1).equals("J")) {
                numericTranslation[indexCounter] = 11;
                indexCounter++;
            } else if (handIterator.substring(0, 1).equals("Q")) {
                numericTranslation[indexCounter] = 12;
                indexCounter++;
            } else if (handIterator.substring(0, 1).equals("K")) {
                numericTranslation[indexCounter] = 13;
                indexCounter++;
            } else if (handIterator.substring(0, 1).equals("A")) {
                numericTranslation[indexCounter] = 14;
                indexCounter++;
            } else {
                numericTranslation[indexCounter] = Integer.parseInt(handIterator.substring(0, 1));
                indexCounter++;
            }
        }

        int HighCardValue = 0;
        String tempHighCard = "";
        tempHighCard = hand.get(0);

        for (int i = 0; i < 5; i++) {
            if (Integer.compare(HighCardValue, numericTranslation[i]) == -1) {
                HighCardValue = numericTranslation[i];
            }
        }

        if (HighCardValue == 10) {
            tempHighCard = "T";
        } else if (HighCardValue == 11) {
            tempHighCard = "J";
        } else if (HighCardValue == 12) {
            tempHighCard = "Q";
        } else if (HighCardValue == 13) {
            tempHighCard = "K";
        } else if (HighCardValue == 14) {
            tempHighCard = "A";
        }

        handRank[0] = 1;
        handRank[1] = 1;
        return tempHighCard;
    }

    public int checkPair(ArrayList<String> hand) {

        int pairCounter = 0;

        for (int i = 0; i < 5; i += 2) {
            for (int j = i + 1; j < 5; j++) {
                if (hand.get(i).substring(0, 1).equals(hand.get(j).substring(0, 1))) {
                    pairCounter++;
                }
            }
        }

        return 1;
    }




    public boolean isStraight(ArrayList<String> hand) {


        return false;
    }

    public boolean isStraightFlush(ArrayList<String> hand){

        return false;
    }

    public void sortHandsAscending(ArrayList<String> hand1, ArrayList<String> hand2){
        sort(hand1);
        sort(hand2);
    }

    public void sort(ArrayList<String> hand){
        String tempValue = "";
        for (int i = 1; i < hand.size(); i++) {
            for(int j = 0; j < hand.size()-i; j++){
                if(Integer.parseInt(hand.get(j)) > Integer.parseInt(hand.get(j+1))){
                    tempValue = hand.get(j);
                    hand.set(j,hand.get(j+1));
                    hand.set(j,hand.get(j+1));
                    hand.set(j+1, tempValue);
                }
            }
        }
    }

    public boolean isFlush(ArrayList<String> hand) {
        for (int i = 1; i <= 4; i++) {
            if (!compareSuitForFlush(hand, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareSuitForFlush(ArrayList<String> hand, int suitPosition) {
        return hand.get(0).substring(1, 2).equals(hand.get(suitPosition).substring(1, 2));
    }

    private void transformToNumericOnlyHand(ArrayList<String> hand1, ArrayList<String> hand2) {
        //String tempSuit = "";
        String cardValueToReplace = "";

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                for (int j = 0; j < hand1.size(); j++) {
                    if (hand1.get(j).substring(0, 1).equals("T")) {
                        numericOnlyHandPlayer1.add("10");
                    } else if (hand1.get(j).substring(0, 1).equals("J")) {
                        numericOnlyHandPlayer1.add("11" );
                    } else if (hand1.get(j).substring(0, 1).equals("Q")) {
                        numericOnlyHandPlayer1.add("12");
                    } else if (hand1.get(j).substring(0, 1).equals("K")) {
                        numericOnlyHandPlayer1.add("13");
                    } else if (hand1.get(j).substring(0, 1).equals("A")) {
                        numericOnlyHandPlayer1.add("14");
                    }
                    else{
                       cardValueToReplace = hand1.get(j).substring(0,1);
                        numericOnlyHandPlayer1.add(cardValueToReplace);
                    }
                }
            } else {
                for (int j = 0; j < hand2.size(); j++) {
                    if (hand2.get(j).substring(0, 1).equals("T")) {
                        numericOnlyHandPlayer2.add("10");
                    } else if (hand2.get(j).substring(0, 1).equals("J")) {
                        numericOnlyHandPlayer2.add("11" );
                    } else if (hand2.get(j).substring(0, 1).equals("Q")) {
                        numericOnlyHandPlayer2.add("12");
                    } else if (hand2.get(j).substring(0, 1).equals("K")) {
                        numericOnlyHandPlayer2.add("13");
                    } else if (hand2.get(j).substring(0, 1).equals("A")) {
                        numericOnlyHandPlayer2.add("14");
                    }
                    else{
                        cardValueToReplace = hand2.get(j).substring(0,1);
                        numericOnlyHandPlayer2.add(cardValueToReplace);
                    }
                }
            }
        }
    }
}
