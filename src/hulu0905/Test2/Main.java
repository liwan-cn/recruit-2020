package hulu0905.Test2;

import java.util.*;

public class Main {

    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int []tmp = func(arr);
        //System.out.println(Arrays.toString(tmp));
        long []res = new long[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = Math.abs(tmp[i]);
            if (tmp[i] == 0) {
                res[i] = (long)arr[i] * (i + 1) % MOD;
            } else {
                res[i] = ((long)arr[i] * tmp[i] % MOD  + res[i-tmp[i]]) % MOD;
            }
            //System.out.println(res[i]);
        }

        long rr = 0;
        for (long l : res) {
            rr = (rr + l) % MOD;
        }
        System.out.println(rr);
    }

    public static int[] func(int[] T) {
        int []res = new int[T.length];
        if (T.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(T.length-1);
        for (int i = T.length-1; i >= 0; i--){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.peek();
                res[index] = i - index;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
