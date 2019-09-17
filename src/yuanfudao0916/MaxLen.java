package yuanfudao0916;

import java.util.*;

public class MaxLen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int s = 0, e = 0;
        int sum = arr[0];
        while(s < n) {
            while (sum <= k){
                max = Math.max(max, e - s + 1);
                if (e + 1 < n)
                    sum += arr[++e];
                else
                    break;
                //System.out.println(s + "," + e + "," + sum);
            }
            sum -= arr[s++];
        }
        System.out.println(max);
    }
}
