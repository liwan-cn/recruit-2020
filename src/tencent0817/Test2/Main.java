package tencent0817.Test2;

// 没通过

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int n = sc.nextInt(), m= sc.nextInt();
            int [][]map = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                for (int j = 0; j < line.length(); j++) {
                    map[i][j] = line.charAt(j) == '.' ? 2 : 1;
                }
            }
            int sx = sc.nextInt() - 1, sy = sc.nextInt() - 1;
            int ex = sc.nextInt() - 1, ey = sc.nextInt() - 1;
            //boolean [][] f = new boolean[n][m];
            System.out.println(dfs(sx, sy, ex, ey, map) ? "YES" : "NO");
        }
    }
    public static boolean dfs(int sx, int sy, int ex, int ey, int [][]map) {
        System.out.println(sx + ";" + sy);
        if (sx < 0 || sx >= map.length) return false;
        if (sy < 0 || sy >= map[sx].length) return false;
        if (sx == ex && sy == ey && map[sx][sy] == 0) return true;
        if (map[sx][sy] <= 0) return false;
        map[sx][sy] --;
        //if (map[sx][sy] == 0) f[sx][sy] = true;
        if (dfs(sx+1, sy, ex, ey, map)) return true;
        if (dfs(sx-1, sy, ex, ey, map)) return true;
        if (dfs(sx, sy+1, ex, ey, map)) return true;
        if (dfs(sx, sy-1, ex, ey, map)) return true;
        map[sx][sy]++;
        return false;
    }
}
/*
2
4 6
X...XX
...XX.
.X..X.
......
1 6
2 2
9 47
....X.X.X.X...X..X.....X..X..X..X....X.X...X..X
XX..X...X.........X...X...X..X.XX......X...X...
..XX...X.......X.....X.....X.XX..X.....X..XX...
.X...XX....X...X.......X.X...X......X.X.X......
X......X..X.XXX....X...X.X.XX..X.......X....X.X
....XX.X...X.XXX.X..XX.XXX...XXX..XX.X.X.XX..XX
.........X...X.XXXX...XX.XX....XX..X...X....X..
.............X....XXXX....X.X...XX.XX.X.X..X...
.X......X.....X......X......X.X.X..X.......XXX.
2 34
7 30
 */
// YES NO