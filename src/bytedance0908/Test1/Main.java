package bytedance0908.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int []arr = new int[n];
        int []dp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            Map.Entry<Integer, Integer> e = map.ceilingEntry(arr[i]);
            if (e != null) {
                dp[e.getValue()] ++;
            }
            map.put(arr[i], i);
        }
        int max = -1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                res = arr[i];
            }
        }
        System.out.println(res);
    }
}
