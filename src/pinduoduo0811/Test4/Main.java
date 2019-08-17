package pinduoduo0811.Test4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean [][]road = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            road[x][y] = true;
            road[y][x] = true;
        }
        int res = 0;
        boolean []f = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!f[i]) {
                dfs(road, f, i);
                res ++;
                //System.out.println(i);
            }
        }
        System.out.println(res);
    }
    public static boolean dfs(boolean[][]road, boolean[] f, int start) {
        boolean res = !f[start];
        f[start] = true;
        //System.out.println(start);
        for (int i = start +1; i < road[start].length; i++) {
            if (road[start][i]) {
                boolean tmp =  dfs(road, f, i);
                if (tmp) return true;
            }
        }
        return res;
    }
}
