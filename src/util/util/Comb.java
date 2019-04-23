package util.util;

public class Comb {
    public static long[][] comb(int n, int m){
        long [][]dp = new long [n+1][m+1];
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= m;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp;
    }
}
