import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        calc.add(10, 5);
        calc.sub(20, 8);
        calc.mul(4, 5);
        calc.div(8, 2);
        calc.add(1, 2);

        
        calc.add(18, 18);
        System.out.println("\nInitial History: ");
        calc.showHistory();
        
        calc.modifyOperation(2, Operations.Type.MUL, 8, 2);
        System.out.println("\nModified History: ");
        calc.showHistory();
    }
}
