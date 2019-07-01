import java.util.ArrayList;

public class PokerRank {
    private PokerRanking rank;

    public ArrayList<Integer> tempPokerHand;


    public PokerRank(PokerRanking rank){
        this.rank = rank;
        tempPokerHand = new ArrayList<Integer>();
    }

    public PokerRanking getRank() {
        return rank;
    }

    public void setRank(PokerRanking rank) {
        this.rank = rank;
    }

    public ArrayList<Integer> getTempPokerHand() {
        return tempPokerHand;
    }
}