class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Handle patterns like "a*", "a*b*", etc., that can match an empty string
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // Direct match or '.' wildcard match
                } else if (pc == '*') {
                    // Case 1: Ignore preceding character (zero occurrences)
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: If the preceding character matches, use dp[i-1][j]
                    if (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
