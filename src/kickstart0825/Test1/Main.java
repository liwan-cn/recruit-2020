package kickstart0825.Test1;

import java.util.Arrays;
import java.util.Scanner;

class UnionFind {

    private int[] root;
    private int count;

    public UnionFind(int size) {
        this.root = new int[size];
        this.count = size;
        Arrays.fill(this.root, -1);
    }

    public int count() {
        return count;
    }

    private int find(int x) {
        if (root[x] < 0) return x;
        return root[x] = find(root[x]);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int xUnion = find(x);
        int yUnion = find(y);
        if (xUnion != yUnion) {
            if (root[xUnion] > root[yUnion]) {
                root[yUnion] += root[xUnion];
                root[xUnion] = yUnion;
            } else {
                root[xUnion] += root[yUnion];
                root[yUnion] = xUnion;

            }
            count--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++)  {
            int n = sc.nextInt(), m = sc.nextInt();
            UnionFind u = new UnionFind(n);
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;
                u.union(x,y);
            }
            int cnt = u.count();
            System.out.println(String.format("Case #%d: %d", t, (cnt - 1) * 2 + (n - cnt)));
            //System.out.println("Case #" + t + ": " + ((cnt - 1) * 2 + (n - cnt)));
        }
    }
}
/*
2
2 1
1 2
3 1
2 3
 */