package util.util;

import java.util.Arrays;

public class MatQuickPower {
    public static final int MOD = 100_000_007;

    public static int[][] matQuickPower(int [][]a, int k) {
        if (k == 1) return a;
        int [][]tmp = matQuickPower(a, k >> 1);
        if ((k & 1) == 0) return matmul(tmp, tmp);
        else return matmul(matmul(tmp, tmp), a);
    }

    public static int[][] matmul(int [][]a, int [][]b) {
        int [][]c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[i].length; k ++){
                    c[i][j] = (int) ((c[i][j] + (long)(a[i][k] % MOD) * (long)(b[k][j] % MOD)) % MOD);
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int [][]a = new int[][]{{1,1}, {1, 0}};
        int [][]c = matQuickPower(a, 20000000);
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        c = a;
        for (int i = 0; i < 20000000-1; i++){
            c = matmul(c, a);
        }
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }
}
