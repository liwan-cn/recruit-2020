package duxiaoman0428.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        if (n == 1){
            System.out.println(0 + " " + 0);
            return;
        }
        long sum = 0, cnt = 0;
        boolean flag = false;
        if (arr[1] > arr[0]){
            sum += arr[1] - arr[0];
            flag = true;
            cnt ++;
        }
        for (int i = 2; i < n; i++){
            if (arr[i] == arr[i-1]) continue;
            if (arr[i] > arr[i-1]){
                sum += arr[i] - arr[i-1];
                if (!flag) {
                    cnt ++;
                    flag = true;
                }
            } else {
                flag = false;
            }
        }
        System.out.println(sum + " " + (cnt<<1));
    }
}
