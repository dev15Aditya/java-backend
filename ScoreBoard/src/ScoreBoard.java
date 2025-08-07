import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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

    // List TC - N log (N) SC - O(N)
    // MinHeap - N log (K) SC - O(K)
    public int topK(int k) {
        // List<Integer> res = new ArrayList<>(scores.values());
        // if(k > res.size()){
        //     k = res.size();
        // } // O(n)

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);
        for(int val: scores.values()){
            minHeap.offer(val);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        } // O(Nlog(K))

        // Collections.sort(res, Collections.reverseOrder()); //O(N(Log(N)))
        int sum = 0;
        // for(int i = 0; i<k; i++){
        //     sum += res.get(i);
        // }
        for(int v: minHeap){
            sum += v;
        }

        return sum;
    }

    public void reset(int id) { // O(k)
        scores.put(id, 0);
    }
}
