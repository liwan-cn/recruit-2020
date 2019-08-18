package xiaohongshu0818.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt(), m =sc.nextInt();
        int []arr = new int[n];
        int max = 0;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
            sum = sum + arr[i];
        }
        if (sum <= t) {
            System.out.println(0);
            return;
        }
        if (t < n) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(arr);
        if (m < n) {
            long tmp = 0;
            for (int i = 0; i < n-m; i++) {
                tmp += arr[i];
            }
            if (tmp > t-m){
                System.out.println(-1);
                return;
            }
        }
        int s = 1, e = max;
        while (s < e) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int mid =  (s + e) / 2;
            int mofaCnt = 0;
            long mofaSH = 0;
            for (int i = arr.length-1; i >= 0; i--) {
                if (arr[i] >= mid) {
                    mofaCnt += arr[i] / mid;
                    if (arr[i] % mid != 0)
                        map.put(arr[i] % mid, map.getOrDefault(arr[i] % mid, 0) + 1);
                } else {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                }
            }
            //System.out.println(mid);
            if (mofaCnt < m) {
                mofaSH = (long)mofaCnt * mid;
                while (mofaCnt < m && map.size() > 0) {
                    Map.Entry<Integer, Integer> entry  = map.lastEntry();
                    //System.out.println(entry.toString());
                    if (entry.getValue() <= (m - mofaCnt)) {
                        mofaCnt += entry.getValue();
                        mofaSH += (long)entry.getKey() * entry.getValue();
                        map.remove(entry.getKey());
                    } else {
                        mofaSH += (long)entry.getKey() * (m - mofaCnt);
                        mofaCnt = m;
                        break;
                    }
                }

            } else {
                mofaCnt = m;
                mofaSH = (long)mofaCnt * mid;
            }
            //System.out.println(mofaCnt + " ; " +mofaSH + "; " + sum);
            if (mofaSH + (t-mofaCnt) == sum){
                System.out.println(mid);
                return;
            }
            if (mofaSH + (t-mofaCnt) < sum) {
                s = mid + 1;
            } else if (mofaSH + (t-mofaCnt) > sum) {
                e = mid - 1;
            }
        }
        System.out.println(s);
    }
}
