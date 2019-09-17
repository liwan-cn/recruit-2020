package other;

import java.util.*;

public class Solution {

    public static final int MOD = 1_000_000_007;

    public int sumSubseqWidths(int []A) {
        int n = A.length;
        int []big = preBig(A);
        int []small = preSmall(A);

        long []max = new long[n];
        for (int i = 0; i < n; i++) {
            max[i] = (long)A[i] * (i - big[i]) % MOD;
            if (big[i] >= 0) {
                max[i] = (max[i] + max[big[i]]) % MOD;
            }
        }
        long []min = new long[n];
        for (int i = 0; i < n; i++) {
            min[i] = (long)A[i] * (i - small[i]) % MOD;
            if (small[i] >= 0) {
                min[i] = (min[i] + min[small[i]]) % MOD;
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (max[i]-min[i]) + MOD) % MOD;
        }

        System.out.println(Arrays.toString(big));
        System.out.println(Arrays.toString(small));
        System.out.println(Arrays.toString(max));
        System.out.println(Arrays.toString(min));
        return (int)res;
    }

    public int[] preBig(int[] T) {
        int []res = new int[T.length];
        Arrays.fill(res, -1);
        if (T.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(T.length-1);
        for (int i = T.length-1; i >= 0; i--){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.peek();
                res[index] = i;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public int[] preSmall(int[] T) {
        int []res = new int[T.length];
        Arrays.fill(res, -1);
        if (T.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(T.length-1);
        for (int i = T.length-1; i >= 0; i--){
            while (!stack.isEmpty() && T[i] < T[stack.peek()]){
                int index = stack.peek();
                res[index] = i;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().sumSubseqWidths(new int[]{2, 1, 3});
    }
}
