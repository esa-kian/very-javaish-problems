/*
Have the function SearchingChallenge(str) take the str parameter being passed and return 1 #ofBrackets if the brackets are correctly matched and each one is accounted for. Otherwise return 0. For example: if str is "(hello [world])(!)", then the output should be 1 3 because all the brackets are matched and there are 3 pairs of brackets, but if str is "((hello [world])" the the output should be 0 because the brackets do not correctly match up. Only "(", ")", "[", and "]" will be used as brackets. If str contains no brackets return 1.
Examples
Input: "(coder)[byte)]"
Output: 0
Input: "(c([od]er)) b(yt[e])"
Output: 1 5
*/

import java.util.*;

class Main {

    public static String SearchingChallenge(String str) {
        // Stack to track unmatched opening brackets
        Stack<Character> stack = new Stack<>();
        int pairCount = 0;

        // Iterate through the characters of the string
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch); // Push opening brackets to the stack
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return "0"; // Unmatched closing bracket
                }

                char top = stack.pop(); // Check the last unmatched opening bracket
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return "0"; // Mismatched brackets
                }

                pairCount++; // Valid pair of brackets
            }
        }

        // If the stack is not empty, there are unmatched opening brackets
        if (!stack.isEmpty()) {
            return "0";
        }

        // If no brackets exist, return 1
        if (pairCount == 0) {
            return "1";
        }

        // Return 1 and the number of pairs if all brackets match
        return "1 " + pairCount;
    }

    public static void main(String[] args) {
        // Example usage
        Scanner s = new Scanner(System.in);
        System.out.print(SearchingChallenge(s.nextLine()));
    }
}
