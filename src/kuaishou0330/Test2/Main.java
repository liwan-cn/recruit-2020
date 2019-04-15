package kuaishou0330.Test2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n= sc.nextInt(), k = sc.nextInt();
        System.out.println(movingCount(k, m, n));
    }
    public static int movingCount(int threshold, int rows, int cols)
    {
        boolean [][] flag = new boolean[rows][cols];
        bfs(flag, 0, 0, threshold);
        int res = 0;
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j++){
                if (flag[i][j]) res++;
            }
        }
        return res;
    }
    private static void bfs(boolean [][]flag, int i, int j, int t){
        if (i < 0 || i >= flag.length || j < 0 || j >= flag[i].length) return;
        if (flag[i][j]) return;
        if (getDigitSum(i) + getDigitSum(j) > t) return;
        flag[i][j] = true;
        bfs(flag, i, j-1, t);
        bfs(flag, i, j+1, t);
        bfs(flag, i-1, j, t);
        bfs(flag, i+1, j, t);
    }
    private static int getDigitSum(int x){
        int res = 0;
        while (x != 0){
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
