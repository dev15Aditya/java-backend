public class App {
    public static void main(String[] args) throws Exception {
        ScoreBoard leaderBoard = new ScoreBoard();

        leaderBoard.addScore(1, 20);

        int topK = leaderBoard.topK(2);
        System.out.println("Scores--> "+ topK);
    }
}
