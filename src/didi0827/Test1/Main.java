package didi0827.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        String []op = new String[n];
        for (int i = 0; i < n-1; i++) {
            arr[i] = sc.nextInt();
            op[i] = sc.next();
        }
        arr[n-1] = sc.nextInt();
        op[n-1] = op[n-2];

        int s = 0, e = 0;
        String state = "+";

        for (int i = 0; i < n; i++) {
            if ((state.equals(op[i]))) {
                e++;
            } else {
                if (state.equals("*") || state.equals("/")) {
                    e++;
                }
                //System.out.print(s + ", "  + e + ";");
                Arrays.sort(arr, s, e);
                s = e = i+1;
                if ((state.equals("+") || state.equals("-")) && op[i].equals("*")) {
                    s--;
                }
                //System.out.println(s + ", "  + e);
            }
            state = op[i];
        }
//        System.out.println(s);
//        System.out.println(e);
        Arrays.sort(arr, s, e);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " " + op[i] + " ");
        }
        System.out.println(arr[n-1]);
    }
}

/*
8
3 / 2 / 1 + -4 * -5 - 3 + 2 + 1

8
3 + 2 + 1 + -4 * -5 - 3 - 2 - 1

9
3 + 2 + 1 + -4 * -5 * -6 - 3 + 2 + 1

8
2 - 1 + 3 + 2 + 1 + -4 * -5 + 1
 */