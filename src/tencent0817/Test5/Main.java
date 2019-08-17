package tencent0817.Test5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]res = new int[3][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[0][0] = sc.nextInt();
                res[1][0] = sc.nextInt();
                res[2][0] = sc.nextInt();
                res[0][1] = res[0][0];
                res[1][1] = res[1][0];
                res[2][1] = res[2][0];
            } else {
                int a0 = sc.nextInt(), a1 = sc.nextInt(), a2 = sc.nextInt();
                int r00 = Math.max(Math.max(res[0][0] + a0, res[0][1] + a0),  Math.max(res[1][0] + a0, res[1][1] + a0));
                int r01 = Math.min(Math.min(res[0][0] + a0, res[0][1] + a0),  Math.min(res[1][0] + a0, res[1][1] + a0));

                int r10 =  Math.max(Math.max(Math.max(res[0][0] + a1, res[0][1] + a1),  Math.max(res[1][0] + a1, res[1][1] + a1)), Math.max(res[2][0] + a1, res[2][1] + a1));
                int r11 =  Math.min(Math.min(Math.min(res[0][0] + a1, res[0][1] + a1),  Math.min(res[1][0] + a1, res[1][1] + a1)), Math.min(res[2][0] + a1, res[2][1] + a1));

                int r20 = Math.max(Math.max(res[2][0] + a2, res[2][1] + a2),  Math.max(res[1][0] + a2, res[1][1] + a2));
                int r21 = Math.min(Math.min(res[2][0] + a2, res[2][1] + a2),  Math.min(res[1][0] + a2, res[1][1] + a2));

                res[0][0] = r00;
                res[1][0] = r10;
                res[2][0] = r20;
                res[0][1] = r01;
                res[1][1] = r11;
                res[2][1] = r21;

                if (a0 == 0) {
                    int t = res[0][0];
                    res[0][0] = -res[0][1];
                    res[0][1] = -t;
                }
                if (a1 == 0) {
                    int t = res[1][0];
                    res[1][0] = -res[1][1];
                    res[1][1] = -t;
                }
                if (a2 == 0) {
                    int t = res[2][0];
                    res[2][0] = -res[2][1];
                    res[2][1] = -t;
                }
            }
        }
        System.out.println(Math.max(Math.max(res[0][0], res[1][0]), res[2][0]));
    }
}
/*
6
1 2 3
8 9 10
5 0 5
-9 -8 -10
0 1 2
5 4 6
 */
//27