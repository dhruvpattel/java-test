/* Data structures for the expressions*/
// Abstract class with method
abstract class ArithmeticExp {
    public abstract int evaluate();
    public abstract String toString();
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
