import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total parking slots: ");
        int n = sc.nextInt();

        ParkingLot lot = new ParkingLot(n);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Status");
            System.out.println("4. Show Total Revenue");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter vehicle number: ");
                    String num = sc.next();
                    System.out.print("Enter vehicle type (CAR/BIKE): ");
                    String typeStr = sc.next().toUpperCase();
                    try {
                        VehicleType type = VehicleType.valueOf(typeStr);
                        lot.parkVehicle(num, type);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid vehicle type!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter vehicle number to remove: ");
                    String num = sc.next();
                    lot.removeVehicle(num);
                }
                case 3 -> lot.displayStatus();
                case 4 -> System.out.println("Total revenue: " + lot.getTotalRevenue());
                case 5 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
