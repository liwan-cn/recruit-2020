package vmware0918;

import java.math.BigInteger;
import java.util.*;

public class PalNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            if (n == 1) {
                System.out.println(k-1);
                continue;
            } else if (n == 2) {
                System.out.println(k*11);
                continue;
            }
            int t = (n + 1) / 2;
            String s = get9(t-1);
            BigInteger res = new BigInteger(s).add(new BigInteger(k+""));
            s = res.toString();
            if (n % 2 == 1) {
                s = s + new StringBuilder(s.substring(0, s.length()-1)).reverse().toString();
            } else {
                s = s = s + new StringBuilder(s).reverse().toString();
            }
            System.out.println(s);
        }
    }

    public static String get9(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "9";
        }
        return s;
    }
}
