package tencent0817.Test1;
// 滑动窗口和的最小值的起始位置

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int win = 0, min = 0;
        int index = 0;
        int []arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] =  sc.nextInt();
            if (i < k) {
                win += arr[i];
                min += arr[i];
            } else {
                win = win + arr[i] - arr[i-k];
                if (min > win){
                    min = win;
                    index = i-k;
                }
            }
        }
        //System.out.println(min);
        System.out.println(index + 2);
    }
}
