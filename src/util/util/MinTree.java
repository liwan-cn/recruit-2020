package util.util;

/**
 * 最小生成树算法
 */

import java.util.List;

public class MinTree {
    static class Edge{
        int a, b, cost;

        /**
         * 边节点构造函数
         * @param a 头
         * @param b 尾
         * @param cost 权重
         */
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    /**
     * 最小生成树
     * @param list 边的列表, 带权重
     * @param n 节点的总个数
     * @return 最小生成树的花费, 如果不连通返回 -1
     */
    public static int minTree(List<Edge> list, int n) {
        //节点间的距离list, 节点个数n
        list.sort((o1, o2) -> o1.cost - o2.cost);
        int []unionFindSet = new int[n];
        for(int i = 0;i < n; i++)
            unionFindSet[i] = -1;
        int cnt = 1, ans = 0;
        for(int i = 0; i < list.size(); i++){
            int a = findRoot(list.get(i).a, unionFindSet);
            int b = findRoot(list.get(i).b, unionFindSet);
            if(a != b){
                unionFindSet[a] = b;
                ans += list.get(i).cost;
                if (++cnt == n) break;
            }
        }
        if (cnt != n) return -1;
        return ans;
    }

    /**
     * 查找节点所在连通图中的根节点
     * @param x 要查找的节点
     * @param unionFindSet 并查集
     * @return 根节点
     */
    public static int findRoot(int x, int []unionFindSet){
        if(unionFindSet[x] == -1)
            return x;
        else{
            return unionFindSet[x] = findRoot(unionFindSet[x], unionFindSet);
        }
    }
}
