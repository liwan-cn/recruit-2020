package baidu0917;

import java.util.*;

public class MinCost {
    static class Edge{
        int u, v;
        long a, b;

        public Edge(int u, int v, long a, long b){
            this.u = u; this.v = v;
            this.a = a; this.b = b;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long fa = sc.nextLong(), fb = sc.nextLong();
        Edge []lines = new Edge[m];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt(), e = sc.nextInt();
            long a = sc.nextLong(), b = sc.nextLong();
            lines[i] = new Edge(s-1, e - 1,  a, b );
        }
    }
}