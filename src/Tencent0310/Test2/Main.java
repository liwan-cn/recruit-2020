package Tencent0310.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int [][]dp = new int[n][2];
        dp[0][0] = 0; dp[0][1] = arr[0];
        if (n <= 2){
            System.out.println(0);
            return;
        }
        dp[1][0] = 0; dp[1][1] = Math.min(dp[0][0], dp[1][0]) + arr[1];
        for (int i = 2; i < n; i++){
            dp[i][0] = Math.min(dp[i-2][1], dp[i-1][1]);
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i];
        }
        System.out.println(Math.min(dp[n-1][0], dp[n-1][1]));

    }
}
