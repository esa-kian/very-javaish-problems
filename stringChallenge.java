/*
Have the function StringChallenge(str) read str which will be a string of roman numerals in decreasing order. The numerals being used are: I for 1, V for 5, X for 10, L for 50, C for 100, D for 500 and M for 1000. Your program should return the same number given by str using a smaller set of roman numerals. For example: if str is "LLLXXXVVVV" this is 200, so your program should return CC because this is the shortest way to write 200 using the roman numeral system given above. If a string is given in its shortest form, just return that same string.
Examples
Input: "XXXVVIIIIIIIIII"
Output: L
Input: "DDLL"
Output: MC
*/

import java.util.*;

class Main {

  public static String StringChallenge(String str) {
    // Map of Roman numerals and their values
    Map<Character, Integer> romanToValue = Map.of(
      'I', 1, 'V', 5, 'X', 10, 'L', 50,
      'C', 100, 'D', 500, 'M', 1000
    );

    // Step 1: Calculate the total value of the input string
    int totalValue = 0;
    for (char ch : str.toCharArray()) {
      totalValue += romanToValue.get(ch);
    }

    // Step 2: Convert totalValue into minimal Roman numeral representation
    StringBuilder result = new StringBuilder();
    int[] values = {1000, 500, 100, 50, 10, 5, 1};
    char[] numerals = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    for (int i = 0; i < values.length; i++) {
      while (totalValue >= values[i]) {
        result.append(numerals[i]);
        totalValue -= values[i];
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    // Example usage
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine()));
  }
}
