package bytedance0825.Test1;

import java.util.*;

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
        int n = sc.nextInt();
        int [][]map = new int[n][n];
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]  = sc.nextInt();
                if (i < j && map[i][j] >= 3) {
                    u.union(i, j);
                }
            }
        }
        System.out.println(u.count());
    }
}
