
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of players: ");
        int totalPlayers = sc.nextInt();

        Game game = new Game(totalPlayers);
        game.start(sc);
    }
}
