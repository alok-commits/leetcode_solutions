class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Handle patterns like a*, a*b*, etc.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);

                if (currentP == '.' || currentP == currentS) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    dp[i][j] = dp[i][j - 2]; // Case: '*' means zero of the preceding element

                    char precedingP = p.charAt(j - 2);
                    if (precedingP == '.' || precedingP == currentS) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // Case: '*' means one or more of the preceding element
                    }
                }
            }
        }

        return dp[m][n];
    }
}