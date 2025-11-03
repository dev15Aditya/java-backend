
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private int totalScore;
    private List<Frame> frames;

    public Player(int id) {
        this.id = id;
        this.totalScore = 0;
        frames = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public int getTotalScore(){
        return totalScore;
    }

    public void addFrame(Frame frame){
        frames.add(frame);
        totalScore += frame.getFrameScore();
    }

    public List<Frame> getFrames(){
        return frames;
    }

    public void displayFrames(){
        System.out.print("Player " + id + " : ");

        for(Frame f: frames){
            System.out.print("{" + f.getDisplaySymbol() + "} ");
        }

        System.out.println("-> " + totalScore);
    }
}
