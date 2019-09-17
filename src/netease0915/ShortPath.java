package netease0915;

import java.util.Deque;
import java.util.*;

public class ShortPath {
    public static List<List<int []>> shortestPath(int[][] grid, int sx, int sy, int ex, int ey) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] state = new int[m][n];
        List<int[]>[][] pre = new ArrayList[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i][j] = new ArrayList<>();
            }
        }

        Deque<int[]> queue = new LinkedList<>();
        //如果左上角为1，则直接不可到达
        if(grid[sx][sy] == 1)
            return new ArrayList<>();
        //初始状态
        state[sx][sy] = 1;
        queue.addLast(new int[]{sx, sy});

        //定义4个方向
        int direction[][] = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int []now = queue.removeFirst();
            int row = now[0];
            int col = now[1];
            for(int i = 0; i < direction.length; i++){
                int new_row = row + direction[i][0];
                int new_col = col + direction[i][1];

                if(new_row >= 0 && new_row < m
                        && new_col >= 0 && new_col < n
                        && grid[new_row][new_col] == 0
                        && (state[new_row][new_col] == 0 || state[new_row][new_col] == state[row][col] + 1)){

                    //如果满足条件，则记录状态并加入到队列中
                    state[new_row][new_col] = state[row][col] + 1;
                    queue.addLast(new int[]{new_row, new_col});
                    pre[new_row][new_col].add(new int[] {row, col});
                    //System.out.print(row + "," + col + ":");
                    //System.out.println(new_row + "," + new_col);

                }
            }
        }
        List<List<int []>> res = new ArrayList<>();
        addPre(res, new ArrayList<int[]>(), pre, sx, sy, ex, ey);

        return res;
    }

    public static void addPre(List<List<int []>> res, List<int []> list, List<int[]>[][] pre, int sx, int sy, int ex, int ey) {
        list.add(new int[]{ex, ey});
        if (ex == sx && ey == sy) {
            Collections.reverse(list);
            res.add(new ArrayList<>(list));
            Collections.reverse(list);

        } else {
            for (int []t : pre[ex][ey]) {
                addPre(res, list, pre, sx, sy, t[0], t[1]);
            }
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt(), n = sc.nextInt();
//        int [][]grid = new int[m][n];
//        int sx = sc.nextInt(), sy = sc.nextInt(), ex = sc.nextInt(), ey = sc.nextInt();
//        while (sc.hasNextInt()) {
//            int x = sc.nextInt(), y = sc.nextInt();
//            grid[x][y] = 1;
//        }
        List<List<int []>> res = shortestPath(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}}, 1, 0, 1, 4);
        //List<List<int []>> res = shortestPath(grid, sx, sy, ex, ey);
        for (List<int []> list: res) {
            for(int i = 0; i < list.size(); i++) {
                int []t = list.get(i);
                System.out.print("{" + t[0] + "," + t[1] + "}");
                if (i != list.size()-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
