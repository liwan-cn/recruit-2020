package util.util;

/**
 * 矩阵快速幂运算
 */

public class MatQuickPower {
    public static final int MOD = 1_000_000_007;

    /**
     * 矩阵快速幂
     * @param a 原始矩阵, 必须为方阵
     * @param k 幂指数
     * @return 矩阵 a 的 k 次方
     */
    public static int[][] matQuickPower(int [][]a, int k) {
        if (k == 1) return a;
        int [][]tmp = matQuickPower(a, k >> 1);
        if ((k & 1) == 0) return matmul(tmp, tmp);
        else return matmul(matmul(tmp, tmp), a);
    }

    /**
     * 矩阵乘法
     * @param a 矩阵 a
     * @param b 矩阵 b
     * @return a * b 的结果
     */
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

}
