/*
Have the function ArrayChallenge(strArr) take the array of strings stored in strArr, which will only contain two strings of equal length and return the Hamming distance between them. The Hamming distance is the number of positions where the corresponding characters are different. For example: if strArr is ["coder", "codec"] then your program should return 1. The string will always be of equal length and will only contain lowercase characters from the alphabet and numbers.
Examples
Input: new String[] {"10011", "10100"}
Output: 3
Input: new String[] {"helloworld", "worldhello"}
Output: 8
*/

import java.util.*; 
import java.io.*;

class Main {

  public static String ArrayChallenge(String[] strArr) {
    // Validate input: Ensure there are exactly two strings of equal length
    if (strArr == null || strArr.length != 2 || strArr[0].length() != strArr[1].length()) {
      return "Input must contain exactly two strings of equal length.";
    }

    String str1 = strArr[0];
    String str2 = strArr[1];
    int hammingDistance = 0;

    // Calculate Hamming distance
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        hammingDistance++;
      }
    }

    // Return result as a string
    return String.valueOf(hammingDistance);
  }

  public static void main (String[] args) {  
    // Keep this function call here     
    Scanner s = new Scanner(System.in);
    // Split the input into an array of strings
    String[] input = s.nextLine().split(", ");
    System.out.print(ArrayChallenge(input)); 
  }
}

