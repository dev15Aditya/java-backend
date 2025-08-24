public class App {
    public static void main(String[] args) throws Exception {
        HashMap map = new HashMap();
        map.createMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);

        map.remove(3);
        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }
}
