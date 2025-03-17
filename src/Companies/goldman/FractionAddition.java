package Companies.goldman;

public class FractionAddition {
    public static void main(String[] args) {
        // Test cases
        int a1 = 1, b1 = 2;  // First fraction: 1/2
        int c1 = 3, d1 = 4;  // Second fraction: 3/4
        System.out.println("For fractions " + a1 + "/" + b1 + " + " + c1 + "/" + d1);
        int[] result1 = addFractions(a1, b1, c1, d1);
        System.out.println("Result: " + result1[0] + "/" + result1[1]);

        // More test cases
        int a2 = 2, b2 = 3;  // 2/3
        int c2 = 1, d2 = 6;  // 1/6
        System.out.println("\nFor fractions " + a2 + "/" + b2 + " + " + c2 + "/" + d2);
        int[] result2 = addFractions(a2, b2, c2, d2);
        System.out.println("Result: " + result2[0] + "/" + result2[1]);
    }

    // Function to add two fractions and return result in simplified form
    // Returns int array where [0] is numerator and [1] is denominator
    public static int[] addFractions(int a, int b, int c, int d) {
        // TODO: Implement this method to:
        // 1. Add the fractions a/b + c/d
        // 2. Simplify the result using GCD
        // 3. Return the simplified fraction as an array [numerator, denominator]

        return new int[]{0, 1}; // placeholder return
    }

    // You might want to implement a helper method for GCD
    private static int findGCD(int a, int b) {
        // TODO: Implement GCD calculation
        return 1; // placeholder return
    }
}