import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    Map<Integer, Integer> scores; // _id, score

    public ScoreBoard() {
        scores = new HashMap<>();
    }

    public void addScore(int id, int score) { // O(1)
        if(!scores.containsKey(id)) {
            scores.put(id, score);
        }

        scores.put(id, scores.get(id) + score);
    }

    public int topK(int k) { // O(k)
        List<Integer> res = new ArrayList<>(scores.values());
        if(k > res.size()){
            k = res.size();
        }

        Collections.sort(res, Collections.reverseOrder());
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += res.get(i);
        }

        return sum;
    }

    public void reset(int id) { // O(k)
        scores.put(id, 0);
    }
}
