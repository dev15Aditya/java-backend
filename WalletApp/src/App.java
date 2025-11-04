
import service.WalletService;

public class App {
    public static void main(String[] args) throws Exception {
        WalletService service = new WalletService();

        service.createUser("u1", "Name1");
        service.createUser("u2", "Name2");
        service.createUser("u3", "Name3");

        service.deposit("u1", 1000);
        service.deposit("u1", 200);

        System.out.println("U1 bal " + service.getBalance("u1"));
        System.out.println("U2 bal " + service.getBalance("u2"));
    }
}
