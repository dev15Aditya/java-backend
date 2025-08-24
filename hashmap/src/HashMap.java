public class HashMap {
    Node[] map;
    public void createMap(){
        map = new Node[1000];

        for(int i = 0; i<1000; i++){
            map[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value){
        int hashKey = hash(key);
        Node head = map[hashKey];

        while(head.next != null){
            if(head.next.key == key){
                head.next.val = value;
                return;
            }
            head = head.next;
        }

        head.next = new Node(key, value);
    }

    public int get(int key){
        int hashKey = hash(key);
        Node head = map[hashKey];

        while(head != null){
            if(head.key == key){
                return head.val;
            }

            head = head.next;
        }

        return -1;
    }
    public void remove(int key){
        int hashKey = hash(key);
        Node head = map[hashKey];

        while(head.next != null){
            if(head.next.key == key){
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }
    }

    private int hash(int key){
        return key % 1000;
    }
}
