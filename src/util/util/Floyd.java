package util.util;

/**
 * 弗洛伊德算法
 */

public class Floyd {

    /**
     * 弗洛伊德算法
     * @param e 权重矩阵
     * @return 最短路径的花费
     */
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
