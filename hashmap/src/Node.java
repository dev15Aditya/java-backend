public class Node<K, V> {
    K key;
    V val;
    Node<K, V> next;

    Node(K k, V v){
        this.key = k;
        this.val = v;
        this.next = null;
    }
}
