/* Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
*/

class Solution {
    public int divide(int dividend, int divisor) {
           // Handle edge cases
        if (divisor == 0) throw new ArithmeticException("Divisor cannot be 0");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert dividend and divisor to positive
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Use subtraction and bit manipulation to compute quotient
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // Double the divisor until it is smaller than the dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest shifted divisor and add the multiple to the quotient
            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign to the result
        quotient = isNegative ? -quotient : quotient;

        // Ensure the result is within the 32-bit signed integer range
        return Math.min(Math.max(Integer.MIN_VALUE, quotient), Integer.MAX_VALUE);
    
    }
}

/*
Approach:
Handle edge cases:

If the dividend is Integer.MIN_VALUE and the divisor is -1, the result exceeds the 32-bit signed integer range. Return Integer.MAX_VALUE.
If the divisor is 1 or -1, return the dividend or -dividend accordingly.
Use subtraction to compute the quotient:

Convert both numbers to positive to simplify calculations, while keeping track of the sign of the result.
Use bit manipulation to optimize subtraction:
Left shift the divisor until it is smaller than or equal to the dividend.
Subtract the shifted divisor and update the quotient accordingly.
Return the result:

Apply the sign to the quotient.
Ensure the result is within the 32-bit integer range.
*/
