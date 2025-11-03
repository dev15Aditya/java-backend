
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    Map<Integer, Player> players;
    final int totalPlayers;
    private static final int TOTAL_ROUNDS = 2;

    public Game(int totalPlayer) {
        this.totalPlayers = totalPlayer;
        this.players = new HashMap<>();
        for (int i = 1; i <= totalPlayers; i++) {
            players.put(i, new Player(i));
        }
    }

    public void start(Scanner sc) {
        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            System.out.println("\n******** ROUND " + round + " ********");

            for (int pid = 1; pid <= totalPlayers; pid++) {
                Player player = players.get(pid);

                System.out.println("Enter score for Player" + pid + " - Chance 1: ");
                int c1 = sc.nextInt();

                int c2 = 0, c3 = 0;

                if (c1 < 10) { // not strike
                    System.out.println("Enter score for Player" + pid + " - Chance 2: ");
                    c2 = sc.nextInt();
                }

                // final round case
                if (round == TOTAL_ROUNDS && (c1 == 10 || c1 + c2 == 10)) {
                    System.out.print("Enter extra ball 1 score: ");
                    c3 = sc.nextInt();
                    System.out.print("Enter extra ball 2 score: ");
                    c3 += sc.nextInt();
                }

                Frame frame = new Frame(c1, c2, c3);
                player.addFrame(frame);

                System.out.println("*********************************************************");
                System.out.println("Player " + pid + " Score | Chance 1 - " + c1 + " pins"
                        + ((c1 < 10) ? " | Chance 2 - " + c2 + "pins" : ""));
                System.out.println("*********************************************************");

                displayScoreboard();
            }
        }
    
        displayFinalResult();
    }


    public void displayScoreboard(){
        System.out.println("**************** SCOREBOARD ****************");
        for(Player p: players.values()){
            p.displayFrames();
        }
        System.out.println("*********************************************************");
    }

    private void displayFinalResult() {
        System.out.println("\n============= FINAL RESULT =============");
        var sortedPlayer = players.values().stream()
                .sorted((a, b) -> Integer.compare(b.getTotalScore(), a.getTotalScore()))
                .toList();
        for(int i = 0; i<sortedPlayer.size(); i++){
            if(i == 0){
                System.out.println("Player " + sortedPlayer.get(i).getId() + " : " + sortedPlayer.get(i).getTotalScore() + " points (Winner)");
            }
            else{
                System.out.println("Player " + sortedPlayer.get(i).getId() + " : " + sortedPlayer.get(i).getTotalScore() + " points");
            }
        }

                // .forEach(p -> System.out.println("Player " + p.getId() + " : " + p.getTotalScore() + " points"));
        System.out.println("========================================");
    }
}
