/* Data structures for the expressions*/
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

class ArithmeticOperation {
    /*Constants for representing the types*/
    public static final int TYPE_NUMBER = 1;
    public static final int TYPE_SUM = 2;
    public static final int TYPE_PROD = 3;
    
    public static void main(String [] args) {
        // constructing the expression 3 + 2 * 5
        ArithmeticExp term = new ArithmeticExp(TYPE_SUM, 0,
                                               new ArithmeticExp(TYPE_NUMBER, 3, null, null),
                                               new ArithmeticExp(TYPE_PROD, 0,
                                                                 new ArithmeticExp(TYPE_NUMBER, 2, null, null),
                                                                 new ArithmeticExp(TYPE_NUMBER, 5, null, null)));
        
        System.out.println(evaluate(term));
    }
    /* Evaluating the expression recursively */
    public static int evaluate(ArithmeticExp term) {
        switch (term.type) {
            case TYPE_NUMBER:
                return term.value;
            case TYPE_SUM:
                return evaluate(term.left) + evaluate(term.right);
            case TYPE_PROD:
                return evaluate(term.left) * evaluate(term.right);
            default:
                return 0;    //error, should never happen
                
        }
    }
}
