/****

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

 

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1
 

Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000


Explanation:
Sorting: Sorting the array helps in finding the threshold for the h-index easily.
Iterate Through the Sorted Array:
At each index i, calculate the number of papers that have citations greater than or equal to citations[i] (this is n - i).
Check if citations[i] is greater than or equal to n - i. If true, then the h-index is n - i.
Complexity:
Time Complexity: O(nlogn) due to sorting.
Space Complexity: O(1), as no extra space is used.

*****/


import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations) {
        // Step 1: Sort the citations array
        Arrays.sort(citations);

        int n = citations.length;
        int hIndex = 0;

        // Step 2: Iterate through the sorted array and find the h-index
        for (int i = 0; i < n; i++) {
            // Number of papers with at least citations[i] citations
            int remainingPapers = n - i;

            // Check if citations[i] can be the h-index
            if (citations[i] >= remainingPapers) {
                hIndex = remainingPapers;
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        // Example 1
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("H-Index: " + hIndex(citations1)); // Output: 3

        // Example 2
        int[] citations2 = {1, 3, 1};
        System.out.println("H-Index: " + hIndex(citations2)); // Output: 1
    }
}
