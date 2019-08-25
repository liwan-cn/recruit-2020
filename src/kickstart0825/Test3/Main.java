package kickstart0825.Test3;

//TLE

import java.util.Scanner;

public class Main {
    static boolean []mark = new boolean[100001];
    static int []prime = new int[100001];
    static int primeSize = 0;
    public static void init() {
        primeSize = 0;
        for (int i = 3; i <= 100000; i++) {
            if (mark[i]) continue;
            prime[primeSize++] = i;
            if (i >= 1000) continue;
            for (int j = i*i; j <= 100000; j += i) {
                mark[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        init();
        //System.out.println(Arrays.toString(prime));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int L = sc.nextInt(), R = sc.nextInt();
            //System.out.println(primeSize);
            int res = 0;
            //StringBuilder sb = new StringBuilder();
            for (int nn = L; nn <= R; nn++){
                int n = nn;
                int []ansPrime = new int[32];
                int ansSize = 0;
                int []ansNum = new int[32];
                for (int i = 0; i < primeSize; i++) {
                    if (n % prime[i] == 0) {
                        ansPrime[ansSize] = prime[i];
                        ansNum[ansSize] = 0;
                        while (n % prime[i] == 0) {
                            ansNum[ansSize] ++;
                            n /= prime[i];
                        }
                        ansSize ++;
                        if (n == 1) break;
                    }
                }
                if (n != 1) {
                    ansPrime[ansSize] = n;
                    ansNum[ansSize++] = 1;
                }
                //System.out.println(Arrays.toString(ansPrime));
                //System.out.println(Arrays.toString(ansNum));
                int odd = 1, even = 0;
                for (int i = 0; i < ansSize; i++) {
                    if (ansPrime[i] == 2) even = ansNum[i];
                    else odd *= (ansNum[i] + 1);
                }
                res +=  Math.abs(odd * even - odd) <= 2 ? 1 : 0;
            }
            System.out.println(String.format("Case #%d: %d", t, res));
        }
    }
}
/*
2
5 10
102 102
 */