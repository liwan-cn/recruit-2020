package bytedance0915;

import java.util.Arrays;
import java.util.Scanner;

public class Happy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cost = sc.nextInt();
        long maxCost = cost;
        long abw[][] = new long[n][3];
        for (int i = 0; i < n; i++) {
            abw[i][0] = sc.nextLong();
            abw[i][1] = sc.nextLong();
            abw[i][2] = sc.nextLong();
            maxCost += abw[i][1];
        }
        long f[][] = new long[(int)maxCost+1][2];
        for (int i= 0; i < n; i++) {
            for (int j = (int)maxCost; j >= abw[i][1]; j--){
                if (j - cost <= f[j- (int)abw[i][1]][0] + abw[i][0] - abw[i][1]) {
                    if (f[j][1] < f[j - (int)abw[i][1]][1] + abw[i][2]) {
                        f[j][1] = f[j - (int)abw[i][1]][1] + abw[i][2];
                        f[j][0] = f[j - (int)abw[i][1]][0] + abw[i][0] - abw[i][1];
                    }
                }
            }
        }
        for (int j = (int)maxCost; j >= 0; j--){
            if (f[j][1] != 0) {
                System.out.println(f[j][1]);
                return;
            }
        }
        System.out.println(0);
    }
}
/*
4 100
100 73 60
100 89 35
30 21 30
10 8 10
 */