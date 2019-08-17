package qihu3600815.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int [][]arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int res = 2 * n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                res += getCnt(arr, i, j);
            }
        }
        System.out.println(res);
    }
    public static int getCnt(int [][]arr, int i, int j) {
        int t = i == 0 ? arr[i][j] : Math.max(0, arr[i][j] - arr[i-1][j]);
        int d = i == arr.length-1 ? arr[i][j] : Math.max(0, arr[i][j] - arr[i+1][j]);
        int l = j == 0 ? arr[i][j] : Math.max(0, arr[i][j] - arr[i][j-1]);
        int r = j == arr[i].length-1 ? arr[i][j] : Math.max(0, arr[i][j] - arr[i][j+1]);
        return t + d + l + r;
    }
}
