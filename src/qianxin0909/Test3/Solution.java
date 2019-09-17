package qianxin0909.Test3;

import java.util.Arrays;

public class Solution {
    public int minCost(int []costs, int []days) {
        Arrays.sort(days);
        int [][]dp = new int[366][3];
        for (int i = 1, j = 0; i <= 365; i++) {
            if (j < days.length && days[j] == i) {
                if (i-1 >= 0){
                    dp[i][0] = costs[0] + min(dp[i-1][0], dp[i-1][1], dp[i-1][2]);
                } else {
                    dp[i][0] = costs[0];
                }

                if (i-7 >= 0){
                    dp[i][1] = costs[1] + min(dp[i-7][0], dp[i-7][1], dp[i-7][2]);
                } else {
                    dp[i][1] = costs[1];
                }

                if (i-30 >= 0){
                    dp[i][2] = costs[2] + min(dp[i-30][0], dp[i-30][1], dp[i-30][2]);
                } else {
                    dp[i][2] = costs[2];
                }
                j++;
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-1][2];
            }
        }
        return min(dp[365][0], dp[365][1], dp[365][2]);
    }
    private int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}
