package bytedance0316.Test4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long []len = new long[n];
        long count = 0;
        for(int i = 0;i < n; i++){
            len[i] = (long)sc.nextInt() * 1000;
        }
        long l = 0L, u = 100000000000L;
        while (l < u){
            long mid = (l+u+1) / 2;
            count = 0;
            for (int i = 0; i < n; i ++){
                count += len[i] / mid;
            }
            //System.out.println(mid);
            if (count < m){
                u = mid - 1;
            }
            else l = mid;
        }
        System.out.println(String.format("%.2f", ((double)l)/ 1000.0));
    }

}
