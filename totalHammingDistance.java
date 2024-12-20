/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

 

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 109
The answer for the given input will fit in a 32-bit integer.
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
         int n = nums.length;
        int totalDistance = 0;

        // Iterate over each bit position (0 to 31 for 32-bit integers)
        for (int i = 0; i < 32; i++) {
            int countOn = 0;

            // Count numbers with the i-th bit set
            for (int num : nums) {
                countOn += (num >> i) & 1; // Check if the i-th bit is 1
            }

            int countOff = n - countOn; // Numbers with the i-th bit not set
            totalDistance += countOn * countOff; // Contribution of this bit
        }

        return totalDistance;
    }
}
