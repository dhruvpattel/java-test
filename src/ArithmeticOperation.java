// Abstract class with method
abstract class ArithmeticExp {
    public abstract int evaluate();
    public abstract String toString();
}
// left and right operands
abstract class Binary extends ArithmeticExp {
    protected ArithmeticExp left;
    protected ArithmeticExp right;

    public Binary(ArithmeticExp left, ArithmeticExp right) {
        this.left = left;
        this.right = right;
    }
}

// Number class
class Number extends ArithmeticExp {
    private int value;

    public Number(int value) {
        this.value=value;
    }
    @Override
    public int evaluate() {
        return value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

// Sum class
class Sum extends Binary {
    public Sum(ArithmeticExp left,ArithmeticExp right) {
        super(left,right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}

// Product class
class Product extends Binary {
    public Product(ArithmeticExp left,ArithmeticExp right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate()*right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
}

// Modulo class
class Modulo extends Binary {
    public Modulo(ArithmeticExp left,ArithmeticExp right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() %right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " % " + right.toString() + ")";
    }
}

//Main class
class ArithmeticOperation {
    public static void main(String [] args) {
        // operation 3 + 2 * 5
        ArithmeticExp expression = new Sum(
                new Number(3),
                new Product(new Number(2), new Number(5))
        );
        System.out.println("Expression: " + expression.toString());
        System.out.println("Evaluation result: " + expression.evaluate());
    }
}

