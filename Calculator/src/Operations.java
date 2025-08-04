public class Operations {
    public enum Type { ADD, SUB, MUL, DIV };

    private Type type;
    private double operand1;
    private double operand2;
    private double result;

    public Operations(Type type, double operand1, double operand2) {
        this.type = type;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = compute();
    }

    private double compute() {
        switch (type) {
            case ADD -> {
                return operand1 + operand2;
            }
            case SUB -> { 
                return operand1 - operand2;
            }
            case MUL -> {
                return  operand1 * operand2;
            }
            case DIV -> {
                if(operand2 == 0) throw new ArithmeticException("Division by zero.");
                return operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operation type.");
        }
    }

    public void update(Type type, double operand1, double operand2){
        this.type = type;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = compute();
    }

    public String toString() {
        return String.format("%s %.2f, %.2f = %.2f", type, operand1, operand2, result);
    }

    public double getResult() {
        return result;
    }
}
