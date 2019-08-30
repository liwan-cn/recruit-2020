package alibaba0830.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int [][]arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean [][]f = new boolean[n][m];
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int cnt = 0;
                if (arr[i][j]==1 && !f[i][j]) cnt ++;
                if (arr[i+1][j]==1 && !f[i+1][j]) cnt ++;
                if (arr[i][j+1]==1 && !f[i][j+1]) cnt ++;
                if (arr[i+1][j+1]==1 && !f[i+1][j+1]) cnt ++;
                if (cnt == 4) {
                    f[i][j]=true; f[i+1][j+1]=true;
                    f[i+1][j]=true; f[i][j+1]=true;
                    res ++;
                }
            }
        }
        System.out.println(res);
    }
}
