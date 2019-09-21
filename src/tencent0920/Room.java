package tencent0920;

import java.util.*;

public class Room {
    static class RGB{
        int r, g, b;
        public RGB(int r, int g, int b){
            this.r = r; this.g = g; this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RGB []rgb = new RGB[n];
        for (int i = 0; i < n; i++) {
            rgb[i] = new RGB(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        int [][]dp = new int[n][3];
        dp[0][0] = rgb[0].r;
        dp[0][1] = rgb[0].g;
        dp[0][2] = rgb[0].b;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i].r;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i].g;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i].b;
        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }
}
