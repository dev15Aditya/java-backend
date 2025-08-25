public class App {
    public static void main(String[] args) throws Exception {
        NotificationService notificationService = new NotificationService();
        InventoryService inventoryService = new InventoryService(notificationService);

        Product p1 = new Product("P101", "iPhone 15 Pro", 0);
        inventoryService.addProduct(p1);

        notificationService.subscribe("bob@java.com", "P101");
        notificationService.subscribe("alice@java.com", "P101");

        inventoryService.updateStock("P101", 5);
    }
}
