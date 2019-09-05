package tencent0901.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int n = sc.nextInt();
            int [] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]  = sc.nextInt();
            }
            System.out.println(majorityElement(arr) ? "NO" : "YES");
        }

    }
    public static boolean majorityElement(int[] nums) {
        int ret = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                cnt ++;
            } else {
                if (cnt == 1 && i + 1 < nums.length) ret = nums[++i];
                else cnt --;
            }
        }
        cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ret) {
                cnt ++;
            }
        }
        //System.out.println(ret);
        //System.out.println(cnt);
        return cnt > nums.length / 2;
    }
}
