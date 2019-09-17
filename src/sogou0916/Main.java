package sogou0916;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            double r = sc.nextDouble(), d = sc.nextDouble();
            double [][]point = new double[n][2];
            for (int i = 0; i < n; i++) {
                point[i][0] = sc.nextDouble();
                point[i][1] = sc.nextDouble();
            }
            boolean []y0 = new boolean[n];
            boolean []y100 = new boolean[n];
            boolean [][]map = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                if (r >= 100.0 - point[i][1]) y100[i] = true;
                if (r >= point[i][1]) y0[i] = true;
                map[i][i] = true;
                for (int j = i+1; j < n; j++) {
                    if ((point[i][0]-point[j][0]) * (point[i][0]-point[j][0]) + (point[i][1]-point[j][1]) * (point[i][1]-point[j][1])< 4 * r * r) {
                        map[i][j] = true; map[j][i] = true;
                    }
                }
            }

            boolean []vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (y0[i] && !vis[i]) {
                    dfs(map, vis, i);
                }
            }

            boolean f = false;
            for (int i = 0; i < n; i++) {
                if (y100[i] && vis[i]){
                    f = true;
                    break;
                }
            }
            System.out.println(f?"N":"Y");
        }
    }
    public static void dfs(boolean [][]map, boolean []vis, int start) {
        if(vis[start]) return;
        vis[start] = true;
        for (int i = 0; i < map.length; i++) {
            if (map[start][i]) {
                dfs(map, vis, i);
            }
        }
    }
}

/*
3 10.0 0.0 13.3 14.2 15.7 25.0 33.3 59.8
1 70.0 0.0 40.5 60.5
2 30.0 30 40.5 35.5 65.6 64.5
 */