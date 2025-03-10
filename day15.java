class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case where result overflows
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert dividend and divisor to positive values (use long to avoid overflow)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Use bitwise shifting to optimize subtraction
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Double the divisor until it exceeds the dividend
            while ((tempDivisor << 1) <= absDividend) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest multiple found
            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply sign and return result
        return isNegative ? -quotient : quotient;
    }
}
