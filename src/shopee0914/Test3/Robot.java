package shopee0914.Test3;

/*
机器人走方格
 */
import java.util.*;

public class Robot {
    public int countWays(int[][] map, int x, int y) {
        int MOD = 1_000_000_007;
        if (map.length == 0) return 0;
        int m = map.length, n = map[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            if (map[0][i] == 1) break;
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++){
            if (map[i][0] == 1) dp[0] = 0;
            for(int j = 1; j < n; j++){
                if (map[i][j] == 1) dp[j] = 0;
                else dp[j] = (dp[j] + dp[j-1]) % MOD;
            }
        }
        return (int)dp[n-1];
    }
}
