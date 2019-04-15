package Bupt0414.TestK;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int [][]mat = new int[n][m];
        int [][]res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
                res[i][j] = 2000;
            }
        }
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++ )
            {
                if (mat[i][j] == 1)
                    res[i][j] = 0;
                else
                {
                    if (i != 0) res[i][j] = Math.min(res[i][j], res[i-1][j] + 1);
                    if (j != 0) res[i][j] = Math.min(res[i][j], res[i][j-1] + 1);
//                    if (i != n-1) res[i][j] = Math.min(res[i][j], res[i+1][j] + 1);
//                    if (j != m-1) res[i][j] = Math.min(res[i][j], res[i][j+1] + 1);
                }
            }

        for (int i = n-1; i >= 0; i --)
            for (int j = m-1; j >= 0; j -- )
            {
//                if (i-1 >= 0) res[i][j] = Math.min(res[i][j], res[i-1][j] + 1);
//                if (j-1 >= 0) res[i][j] = Math.min(res[i][j], res[i][j-1] + 1);
                if (i+1 < n) res[i][j] = Math.min(res[i][j], res[i+1][j] + 1);
                if (j+1 < m) res[i][j] = Math.min(res[i][j], res[i][j+1] + 1);
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0)
                    System.out.print(res[i][j]);
                else
                    System.out.print(" " + res[i][j]);
            }
            System.out.println();
        }
    }
}
