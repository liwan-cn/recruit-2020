package util.util;

/**
 * 素数筛法分解质因数 eg: 12 = 2^2 * 3^1
 */

import java.util.*;

public class PrimeSieve {

    /**
     * 表示因子与对应的幂指数
     */
    class Factors{
        public int factor;
        public int power;
        public Factors(int factor, int power) {
            this.factor = factor;
            this.power = power;
        }
        @Override
        public String toString(){
            return "{" + factor + ": " + power + "}";
        }
    }

    public List<Integer> prime;

    public PrimeSieve() {
        this(100_001);
    }

    /**
     * 初始化, 素数筛法, 寻找所有的素数
     * @param maxSize 假设的素数最大值
     */
    public PrimeSieve(int maxSize) {
        boolean []mark = new boolean[maxSize];
        this.prime = new ArrayList<>();
        for (int i = 2; i < maxSize; i++) {
            if (mark[i]) continue;
            prime.add(i);
            if (i >= (int)Math.sqrt(maxSize)) continue;
            for (int j = i*i; j < maxSize; j += i) {
                mark[j] = true;
            }
        }
    }

    /**
     * 素因数分解
     * @param n 待分解的数
     * @return 分解后的结果 eg: 60 = 2^2 * 3^1 * 5^1
     */
    public List<Factors> primeFactors(int n) {
        List<Factors> factors = new ArrayList<>(32);
        for (int i = 0; i < this.prime.size(); i++) {
            int factor = prime.get(i);
            if (n % factor == 0) {
                Factors f = new Factors(factor, 0);
                while (n % factor == 0) {
                    f.power ++;
                    n /= factor;
                }
                factors.add(f);
                if (n == 1) break;
            }
        }
        if (n != 1) {
            factors.add(new Factors(n, 1));
        }
        return factors;
    }

}
