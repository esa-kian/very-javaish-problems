/*
Have the function MathChallenge(str) read str which will be an arithmetic expression composed of only integers and the operators: +,-,* and / and the input expression will be in postfix notation (Reverse Polish notation), an example: (1 + 2) * 3 would be
1 2 + 3 * in postfix notation. Your program should determine the answer for the given postfix expression. For example: if str is 2 12 + 7 / then your program should output 2.
Examples
Input: "1 1 + 1 + 1 +"
Output: 4
Input: "4 5 + 2 1 + *"
Output: 27
*/

import java.util.*;

class Main {

    public static int MathChallenge(String str) {
        // Stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Split the input into tokens
        String[] tokens = str.split(" ");

        // Iterate through each token in the postfix expression
        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop the top two operands
                int b = stack.pop();
                int a = stack.pop();

                // Perform the operation and push the result back onto the stack
                stack.push(applyOperator(a, b, token));
            } else {
                // Push numbers onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result will be the only element left in the stack
        return stack.pop();
    }

    // Helper method to determine if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Helper method to apply the operator to two operands
    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        // Example usage
        Scanner s = new Scanner(System.in);
        System.out.print(MathChallenge(s.nextLine()));
    }
}
