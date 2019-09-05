package tencent0901.Test4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char []sca = s.toCharArray();
        int sl = sca.length;
        int t = sc.nextInt();
        int res = 0;
        while (t-- > 0) {
            String now = sc.next();
            char []ca = now.toCharArray();
            int l = ca.length;
            boolean f = true;
            for (int i = 0; i < sl; i++) {
                if (sca[i] != ca[i % l]) {
                    f = false;
                    break;
                }
            }
            if (f) res ++;
        }
        System.out.println(res);
    }
}
