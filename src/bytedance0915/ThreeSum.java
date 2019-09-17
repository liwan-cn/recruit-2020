package bytedance0915;

/*
Three Sum < K
 */
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int []arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] =sc.nextInt();
        }
        int K = sc.nextInt();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < m - 2; i ++) {
            for (int s = i + 1, e = m-1; s < e;) {
                if (arr[i] + arr[s] + arr[e] < K) {
                    res += e - s;
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(res);
    }
}
