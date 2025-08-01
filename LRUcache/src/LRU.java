
import java.util.HashMap;
import java.util.Map;

public class LRU {
    Map<Integer, Node> cache;
    Node head, tail;
    int maxSize = 0;

    public LRU(int capacity) {
        maxSize = capacity;
        cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node currNode = cache.get(key);
        if (currNode == null)
            return -1;

        moveToHead(currNode);

        return currNode.value;
    }

    public void put(int key, int value) {
        Node curr = cache.get(key);

        if(curr != null){
            curr.value = value;
            moveToHead(curr);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);

            if(cache.size() > maxSize){
                Node lru = removeTail();
                cache.remove(lru.key);
            }
        }
    }

    public void addToHead(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node removeTail() {
        Node lru = tail.prev;

        removeNode(lru);
        return lru;
    }

}
