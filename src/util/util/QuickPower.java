package util.util;

/**
 * 快速幂运算
 */

public class QuickPower {

    /**
     * 快速幂运算
     * @param x 底数
     * @param n 幂指数
     * @return x 的 n 次幂
     */
    public int quickPower(int x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE)
            return 1 / x * quickPower(1 / x , Integer.MAX_VALUE);
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n & 1) == 0 ? quickPower(x * x, n >> 1) : x * quickPower(x * x, n >> 1);
    }
}
