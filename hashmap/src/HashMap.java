public class HashMap<K, V> {
    Node<K, V>[] map;
    final private int capacity = 1000;

    @SuppressWarnings("unchecked")
    public void createMap(){
        map = (Node<K, V>[]) new Node[capacity];
    }

    public void put(K key, V value){
        int hashKey = hash(key);

        if(map[hashKey] == null) {
            map[hashKey] = new Node<>(null, null);
        }

        Node<K, V> head = map[hashKey];

        while(head.next != null){
            if(head.next.key.equals(key)){
                head.next.val = value;
                return;
            }
            head = head.next;
        }

        head.next = new Node<>(key, value);
    }

    public V get(K key){
        int hashKey = hash(key);
        Node<K, V> head = map[hashKey];

        while(head != null){
            if(head.key.equals(key)){
                return head.val;
            }

            head = head.next;
        }

        return null;
    }

    public void remove(K key){
        int hashKey = hash(key);
        Node<K, V> head = map[hashKey];

        while(head.next != null){
            if(head.next.key.equals(key)){
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }
    }

    private int hash(K key){
        return Math.abs(key.hashCode() % capacity);
    }
}
