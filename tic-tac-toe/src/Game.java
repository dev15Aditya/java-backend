public class Game {
    private final Board board;
    private Player current;

    public Game() {
        board = new Board();
        current = Player.X; // x start the game
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return current;
    }

    public Result makeMove(int row, int col) {
        if(!board.isValidMove(row, col)){
            return new Result(false, Status.IN_PROGRESS, null, "Invalid move");
        }

        board.placeMove(row, col, current);
        if(board.checkWin(current)){
            return new Result(true, Status.WIN, current, "Player " + current + " wins.");
        }

        if(board.isFull()){
            return new Result(true, Status.DRAW, null, "Game is a draw.");
        }

        current = current.opposite();
        return new Result(true, Status.IN_PROGRESS, null, "Move accepted");
    }

    public void reset() {
        board.reset();
        current = Player.X;
    }
}
