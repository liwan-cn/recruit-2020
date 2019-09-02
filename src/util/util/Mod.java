package util.util;

public class Mod {

    public static final long MOD = 1_000_000_007;

    /**
     * 模乘
     * @param x
     * @param y
     * @return x * y % MOD
     */
    public static long mul(long x, long y) {
        return ((x % MOD) * (y % MOD)) % MOD;
    }

    /**
     * 模加
     * @param x
     * @param y
     * @return (x + y) % MOD
     */
    public static long add(long x, long y) {
        return  ((x % MOD) + (y % MOD)) % MOD;
    }

    /**
     * 模快速幂
     * @param x
     * @param n
     * @return x^n % MOD
     */
    public static long quickPower(long x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x % MOD;
        long tmp = quickPower(x, n >> 1);
        return (n & 1) == 0 ? mul(tmp, tmp) : mul(x, mul(tmp, tmp));
    }

    /**
     * 分数求模
     * @param a 分母
     * @param b 分子
     * @return (b/a) % MOD
     */
    public static long fractionMod(long a, long b) {
        return mul(b, quickPower(a, MOD-2));
    }

}
