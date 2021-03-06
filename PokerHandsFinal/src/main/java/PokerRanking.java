public enum PokerRanking {
    HIGHCARD (1),
    PAIR (2),
    TWOPAIRS (3),
    THREEOFAKIND (4),
    STRAIGHT (5),
    FLUSH (6),
    FULLHOUSE (7),
    FOUROFAKIND (8),
    STRAIGHTFLUSH (9);

    public final int rank;

    PokerRanking(int rank){
        this.rank = rank;
    }
}