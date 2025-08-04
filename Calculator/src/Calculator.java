
import java.util.LinkedList;

public class Calculator {
    private final LinkedList<Operations> history = new LinkedList<>();

    public double add(double a, double b){
        return perform(Operations.Type.ADD, a, b);
    }

    public double sub(double a, double b){
        return perform(Operations.Type.SUB, a, b);
    }

    public double mul(double a, double b){
        return perform(Operations.Type.MUL, a, b);
    }

    public double div(double a, double b){
        return perform(Operations.Type.DIV, a, b);
    }

    private double perform(Operations.Type type, double a, double b) {
        Operations op = new Operations(type, a, b);

        if(history.size() == 5) {
            history.removeFirst();
        }
        history.add(op);
        return op.getResult();
    }

    public void showHistory() {
        if(history.isEmpty()){
            System.out.println("No operations yet.");
            return;
        }

        for(int i = 0; i < history.size(); i++){
            System.out.println(i + ": " + history.get(i));
        }
    }

    public void modifyOperation(int index, Operations.Type newType, double a, double b){
        if(index < 0 || index >= history.size()){
            throw new IndexOutOfBoundsException("Invalid history index.");
        }

        Operations op = history.get(index);
        op.update(newType, a, b);
    }
}
