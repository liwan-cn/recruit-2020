package util.util;

import java.util.*;

public class PrimeSieve {

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

    public static void main(String[] args) {
        PrimeSieve ps = new PrimeSieve();
        for (int i = 100; i < 3000; i++) {
            System.out.print(i + "\t");
            System.out.println(ps.primeFactors(i));
        }
    }
}
