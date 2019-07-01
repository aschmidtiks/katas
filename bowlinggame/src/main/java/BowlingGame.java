public class BowlingGame {

    private int score = 0;
    private String rolls = "";
    private String transformedRolls;
    private static final int FRAMES = 10;

    public void setRolls(String value) {
        rolls = value;
        transformedRolls = rolls.replace('-', '0');
    }

    public int getScore() {
        return score;
    }

    public void calculateScore() {
        int turn = 0;
        int score = 0;
        for (int i = 0; i < FRAMES; i++) {
            if (isStrike(turn)) {
                score += calculateStrike(turn);
                turn += 1;
            } else if (isSpare(turn)) {
                score += calculateSpare(turn);
                turn += 2;
            } else {
                score += calculateNormalShot(turn, 0, 1);
                turn += 2;
            }
        }
        this.score += score;
    }

    public int calculateStrike(int tempTurn) {
        int score = 10;
        if (isStrike(tempTurn + 1)) {
            score += 10;
            if (isStrike(tempTurn + 2)) {
                score += 10;
            } else {
                score += updateScore(tempTurn, 2, 3);
            }
        } else if (isSpare(tempTurn + 1)) {
            score += 10;
        } else {
           score += calculateNormalShot(tempTurn, 1, 2);
        }
        return score;
    }

    public int calculateSpare(int tempTurn) {
        int score = 10;
        if (isStrike(tempTurn + 2)) {
            score += 10;
        } else {
            score += updateScore(tempTurn, 2, 3);
        }

        return score;
    }

    public int updateScore(int tempTurn, int index1, int index2) {
        return Integer.parseInt(transformedRolls.substring(tempTurn + index1, tempTurn + index2));
    }

    public int calculateNormalShot(int tempTurn, int index1, int index2) {
        int score = 0;
        score += updateScore(tempTurn, index1, index2);
        tempTurn++;
        score += updateScore(tempTurn, index1, index2);
        return score;
    }

    public boolean isStrike(int tempTurn) {
       return "X".equals(transformedRolls.substring(tempTurn, tempTurn + 1));
    }

    public boolean isSpare(int tempTurn) {
        return rolls.substring(tempTurn + 1, tempTurn + 2).equals("/");
    }
}
