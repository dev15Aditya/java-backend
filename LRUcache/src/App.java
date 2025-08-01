public class App {
    public static void main(String[] args) throws Exception {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 1

        lru.put(3, 3); // evicts key 2
        System.out.println(lru.get(2)); // -1 (not found)
        
        lru.put(4, 4); // evicts key 1
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 3
        System.out.println(lru.get(4)); // 4
    }
}
