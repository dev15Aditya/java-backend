
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<NotificationRequest> requests = new ArrayList<>();

    public void subscribe(String email, String prodId){
        requests.add(new NotificationRequest(email, prodId));
        System.out.println(email + " subscribed for product " + prodId);
    }

    public void notifyUser(String productId){
        for(NotificationRequest req: requests){
            if(req.productId.equals(productId)) {
                System.out.println("Notifying " + req.userEmail + " : Product " + productId + " is back in stock!");
            }
        }
    }
}
