package util.util;

public class Floyd {
    public int[][] floyd(int [][]e) {
        int n = e.length;
        for (int k = 0 ; k < n ; k ++){
            for (int i = 0 ; i < n ; i ++) {
                for (int j = 0 ; j < n ; j ++) {
                    if(e[i][j] > e[i][k] + e[k][j])
                        e[i][j] = e[i][k] + e[k][j];
                }
            }
        }
        return e;
    }
}
