package Baidu0402.Test2;


public class Main {
    private static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int []values = new int[]{-1, 2, 3, 2};
        int [][]edges = new int[][]{{1,2}, {1, 3}, {3, 4}};
        int [][]child = new int[values.length + 1][2];
        for (int i = 0; i < edges.length; i++) {
            if (child[edges[i][0]][0] == 0){
                child[edges[i][0]][0] = edges[i][1];
            } else {
                child[edges[i][0]][1] = edges[i][1];
            }
        }
        //int [][]path = new int[values.length + 1][2];
        maxPath(1, child, values);
        System.out.println(res);
    }
    private static int[] maxPath(int start, int [][]child, int []values){
        if (start == 0) return new int[]{1, 1};
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int []l = maxPath(child[start][0], child, values);
        int []r = maxPath(child[start][1], child, values);
        if (child[start][0] != 0) {
            max = Math.max(max, Math.max(l[0] * values[start - 1], l[1] * values[start - 1]));
            min = Math.min(min, Math.min(l[0] * values[start - 1], l[1] * values[start - 1]));
        }
        if (child[start][1] != 0) {
            max = Math.max(max, Math.max(r[0] * values[start - 1], r[1] * values[start - 1]));
            min = Math.min(min, Math.min(r[0] * values[start - 1], r[1] * values[start - 1]));
        }
        if (child[start][0] == 0 && child[start][1] == 0){
            max = values[start - 1];
            min = values[start - 1];
        }
        if(child[start][0] != 0 && child[start][1] != 0)
            res = Math.max(res, Math.max(
                Math.max(l[0] * r[0] * values[start-1], l[0] * r[1] * values[start-1]),
                Math.max(l[1] * r[0] * values[start-1], l[1] * r[1] * values[start-1])));
        //System.out.println(start + ":" + max + "," + min);
        return new int[]{max, min};
    }

}
