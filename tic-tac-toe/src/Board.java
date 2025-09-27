public class Board {
    private final Player[][] grid;
    public static final int SIZE = 3;

    public Board() {
        grid = new Player[SIZE][SIZE];
        reset();
    }

    public void reset() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                grid[r][c] = Player.EMPTY;
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == Player.EMPTY;
    }

    public boolean placeMove(int row, int col, Player p) {
        if (!isValidMove(row, col))
            return false;

        grid[row][col] = p;

        return true;
    }

    public boolean isFull() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == Player.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(Player p) {
        // row col
        for (int i = 0; i < SIZE; i++) {
            if ((grid[0][i] == p && grid[1][i] == p && grid[2][i] == p) ||
                    (grid[i][0] == p && grid[i][1] == p && grid[i][2] == p))
                return true;
        }

        // diagonal
        return ((grid[0][0] == p && grid[1][1] == p && grid[2][2] == p) ||
                (grid[2][0] == p && grid[1][1] == p && grid[0][2] == p));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                sb.append(" ").append(grid[r][c].getSymbol()).append(" ");
                if (c < SIZE - 1) sb.append("|");
            }
            sb.append(System.lineSeparator());
            if (r < SIZE - 1) sb.append("---+---+---").append(System.lineSeparator());
        }
        return sb.toString();
    }

}
