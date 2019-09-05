package hulu0905.Test3;

import java.util.*;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = -sc.nextInt();
            }
        }

        boolean [][]flag = new boolean[n][n];

        int [][]tmp = new int[n][n];

        if (map[0][0] != 1) {
            dfs(map, flag, 0, 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                tmp[i][j] = flag[i][j] ? 0 : 20000;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            }
        }

        System.out.println(map[n-1][n-1]);

    }

    public static void dfs(int [][]map, boolean [][]flag, int i, int j) {
        if (i >= map.length || i < 0 || j >= map[i].length || j < 0) return;
        if (flag[i][j]) return;
        else if (map[i][j] == 1) return;
        else {
            flag[i][j] = true;
            dfs(map, flag, i + 1, j);
            dfs(map, flag, i - 1, j);
            dfs(map, flag, i, j + 1);
            dfs(map, flag, i, j - 1);
        }
    }

}
