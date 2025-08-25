
import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Product> productMap = new HashMap<>();
    private NotificationService notificationService;

    InventoryService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void addProduct(Product product){
        productMap.put(product.id, product);
    }

    public void updateStock(String productId, int newStock){
        Product p = productMap.get(productId);

        if(p != null){
            p.stock = newStock;
            System.out.println("Stock updated for product " + p.name + ": " + newStock);
            if(newStock > 0){
                notificationService.notifyUser(productId);
            }
        }
    }
}
