package bytedance0915;

import java.util.*;

public class TransFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int [][]arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (o1, o2)->(o1[0]-o2[0]));
        long max = arr[0][1];
        long rem = arr[0][1];
        for (int i = 1; i  < m; i++) {
            rem = Math.max(0, rem - (arr[i][0] - arr[i-1][0])) + arr[i][1];
            max = Math.max(rem, max);
        }
        System.out.println(arr[m-1][0] + rem + " " + max);
    }
}

/*
3
1 100
2 100
3 1
 */