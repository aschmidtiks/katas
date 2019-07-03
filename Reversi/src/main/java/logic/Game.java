package logic;

public class Game {

    private Board board;

    private Turn turn = new Turn(Player.PLAYER1);

    public Game(Board board) {
       this.board = board;
       runGame();
    }
    public Game() {
        board = new Board();
        runGame();
    }

    public Turn getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    private void runGame() {
        switch(turn.getCurrentPlayer()){
            case PLAYER1: {
                //Logic Player 1
                board.calcLegalMoves(turn.getCurrentPlayer());
                break;
            }

            case PLAYER2: {
                //Logic Player 2
                board.calcLegalMoves(turn.getCurrentPlayer());
                break;
            }

        }
    }


}
