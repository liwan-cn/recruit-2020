package other;

import java.math.BigInteger;

public class MinRightInteger {
    public static BigInteger minRightInteger(int n) {
        BigInteger []remain2Num = new BigInteger[n];
        remain2Num[1] = new BigInteger("1");
        BigInteger base = new BigInteger("10"), N = new BigInteger(String.valueOf(n));
        for (BigInteger now = new BigInteger("10"); ; now = now.multiply(base)) {
            //System.out.print(now + "\t");
            int remain = now.remainder(N).intValue();
            if(remain2Num[remain] == null){
                remain2Num[remain] = now;
            }
            //System.out.print(now + ":" + remain + ";\t");
            for (int i = 1; i < n; i++) {
                if(remain2Num[i] == null)
                    continue;
                int newRemain = (remain + i) % n;

                if(remain2Num[newRemain] == null && remain2Num[i].compareTo(now) < 0){
                    remain2Num[newRemain] = now.add(remain2Num[i]);
                }
            }

            if (remain2Num[0] != null) break;
        }
        return remain2Num[0].divide(N);
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10000; i++) {
            System.out.println(minRightInteger(i));
        }
    }
}
