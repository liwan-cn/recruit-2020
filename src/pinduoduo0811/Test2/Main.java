package pinduoduo0811.Test2;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int mid = arr.length / 2;
        int left = 0, right = 0;
        for (int i = 0; i <= mid; i ++) {
            left += arr[i];
        }
        for (int i = mid+1; i < arr.length; i ++) {
            right += arr[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            mid = (arr.length/2 + i) % arr.length ;
            int lc = 0, rc = 0;
            if (n % 2 == 0) {
                lc = n / 2;
                rc = n / 2;
            } else {
                lc = n / 2 + 1;
                rc = n / 2;
            }
            int l = sum(arr[mid] - lc + 1, arr[mid]);
            int r = sum(arr[mid] + 1, arr[mid] + rc);
            res = Math.min(res, l - left + right - r);
        }
        System.out.println(res);
    }
    public static int sum(int s, int e){
        return (s + e) * (s - e + 1) / 2;
    }

}
