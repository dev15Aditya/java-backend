
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of time you want to roll the dice: ");
        boolean isRollComplete = false;
        do {

            try {
                int roll = sc.nextInt();

                for (int i = 0; i < roll; i++) {
                    int randomVal = rand.nextInt(6) + 1;

                    String op = display(randomVal);
                    System.out.println(op);
                }
                isRollComplete = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine();
                System.out.print("Try again: ");
            }

        } while (!isRollComplete);
        sc.close();
    }

    public static String display(int val) {
        return switch (val) {
            case 1 -> "_______\n|     |\n|  0  |\n|     |\n-------";
            case 2 -> "_______\n|  0  |\n|     |\n|  0  |\n-------";
            case 3 -> "_______\n|0    |\n|  0  |\n|    0|\n-------";
            case 4 -> "_______\n|0   0|\n|     |\n|0   0|\n-------";
            case 5 -> "_______\n|0   0|\n|  0  |\n|0   0|\n-------";
            case 6 -> "_______\n|0   0|\n|0   0|\n|0   0|\n-------";
            default -> "Not a valid Input!";
        };
    }
}
