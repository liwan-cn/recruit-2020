package Tencent0310.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1){
            System.out.println(0);
            return;
        }
        int start = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min1 = arr[0], min2 = arr[1], max1 = arr[n-1], max2 = arr[n-2];
        if (start <= min1) System.out.println(max2 - start);
        else if(start >= max1) System.out.println(start - min2);
        else if (start > min1 && start <= min2){
            int res = Math.min(max1 - start, max2 - start + 2 * (start - min1));
            System.out.println(res);
        }
        else if (start < max1 && start >= max2){
            int res = Math.min(start - min1, start - min2 + 2 * (max1 - start));
            System.out.println(res);
        }
        else {
            int res1 = Math.min(2 * (max1 - start) + start - min2,
                    2 * (start - min1) + max2 - start);
            int res2 = Math.min(max1 - start + 2 * (start - min2),
                    start - min1 + 2 * (max2 - start));
            System.out.println(Math.min(res1, res2));
        }
        //System.out.println(max1 + ";" + max2 + ";" + min1 + ";" + min2);
    }
}
