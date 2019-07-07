package bytedance0707.Test4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int []w = new int [m];
        int []v = new int [m];
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int []dp = new int[n+1];
        for (int i = 0; i < m; i++)
            for (int j = n; j >= w[i]; j--)
                dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
        System.out.println(dp[n]);
    }
}
