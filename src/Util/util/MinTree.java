package Util.util;

import java.util.Collections;
import java.util.List;

public class MinTree {
    static class Edge{
        int a, b, cost;
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    public static int minTree(List<Edge> list, int n) {
        //节点间的距离list, 节点个数n
        Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);
        int []unionFindSet = new int[n + 1];
        for(int i = 0;i <= n; i++)
            unionFindSet[i] = -1;
        int ans = 0;
        for(int i = 0; i < list.size(); i++){
            int a = findRoot(list.get(i).a, unionFindSet);
            int b = findRoot(list.get(i).b, unionFindSet);
            if(a != b){
                unionFindSet[a] = b;
                ans += list.get(i).cost;
            }
        }
        return ans;
    }
    public static int findRoot(int x, int []unionFindSet){
        if(unionFindSet[x] == -1)
            return x;
        else{
            int tmp = findRoot(unionFindSet[x], unionFindSet);
            unionFindSet[x] = tmp;
            return tmp;
        }
    }
}
