package zhaoshang0317.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int []arr = new int[N];
        int min = Integer.MAX_VALUE;
        boolean p = false, n = false, zero = false;
        for (int i =0; i < N;i++){
            arr[i] = sc.nextInt();
            if (arr[i] > 0) p = true;
            if (arr[i] < 0) n = true;
            if (arr[i] == 0) zero = true;
            min = Math.min(min, Math.abs(arr[i]));
        }
        int res = 0;
        for (int i : arr){
            res += Math.abs(i);
        }
        if ((p && n) || zero){
            System.out.println(res);
        }else {
            System.out.println(res - 2 * min);
        }

    }
}
