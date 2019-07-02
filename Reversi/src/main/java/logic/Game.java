package logic;

public class Game {

    private Board board;
    private Turn turn = new Turn(Player.PLAYER1);

    public Game(Board board) {
        this.board = board;

       runGame();
    }

    private void runGame() {
        switch(turn.getCurrentPlayer()){
            case PLAYER1: {
                //Logic Player 1

                break;
            }

            case PLAYER2: {
                //Logic Player 2
                break;
            }

        }
    }

}
