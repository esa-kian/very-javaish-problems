/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1
*/

class Solution {
    public int hammingDistance(int x, int y) {
        // Step 1: XOR the two numbers
        int xor = x ^ y;

        // Step 2: Count the number of 1s in the binary representation of xor
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // Check the least significant bit
            xor >>= 1; // Right shift to process the next bit
        }

        return count;
    }
}
