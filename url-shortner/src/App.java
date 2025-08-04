import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        UrlShortner us = new UrlShortner();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Shorten URL\n2. Expand URL\n3. Exit");
            int choice = -1;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter a number");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter long URL: ");
                    String longUrl = sc.nextLine();
                    System.out.println("Shortened URL: " + us.shortenUrl(longUrl));
                }
                case 2 -> {
                    System.out.print("Enter short URL: ");
                    String shortUrl = sc.nextLine();
                    System.out.println("Original URL: " + us.getLongUrl(shortUrl));
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
