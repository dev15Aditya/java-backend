public class App {

    class Coords {
        int x, y;

        Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Triangle{
        Coords a, b, c;

        Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.a = new Coords(x1, y1);
            this.b = new Coords(x2, y2);
            this.c = new Coords(x3, y3);
        }
        
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
