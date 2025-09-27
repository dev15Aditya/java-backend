import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Tic-Tac-Toe (3x3). Enter moves as: row col (1-3). X goes first.");
        while (true) {
            System.out.println();
            System.out.println(game.getBoard());
            Player cur = game.getCurrentPlayer();
            System.out.print("Player " + cur.getSymbol() + " move (row col), or 'q' to quit: ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("q")) {
                System.out.println("Quit. Bye.");
                break;
            }
            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Please enter two numbers, e.g. `2 3`");
                continue;
            }
            int r, c;
            try {
                r = Integer.parseInt(parts[0]) - 1;
                c = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers. Use 1-3.");
                continue;
            }
            
            Result res = game.makeMove(r, c);
            if (!res.ok) {
                System.out.println(res.message);
                continue;
            }
            if (res.status == Status.WIN) {
                System.out.println();
                System.out.println(game.getBoard());
                System.out.println("Player " + res.winner + " wins! " + res.message);
                System.out.print("Play again? (y/n): ");
                String yn = sc.nextLine().trim();
                if (yn.equalsIgnoreCase("y")) {
                    game.reset();
                } else
                    break;
            } else if (res.status == Status.DRAW) {
                System.out.println();
                System.out.println(game.getBoard());
                System.out.println("It's a draw!");
                System.out.print("Play again? (y/n): ");
                String yn = sc.nextLine().trim();
                if (yn.equalsIgnoreCase("y")) {
                    game.reset();
                } else
                    break;
            }
        }
        sc.close();
    }
}
