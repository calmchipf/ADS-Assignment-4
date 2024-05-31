package examples;

// Recursive function to calculate factorial of a number
public class RecursionExample {
    public static int factorial(int n) {
        if (n == 0) {  // Base case
            return 1;
        }
        return n * factorial(n - 1);  // Recursive call
    }
}
