package didi0919;

import java.util.*;

public class Garbage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        UnionFind uf = new UnionFind(n);
        while (m-- > 0) {
            int a = sc.nextInt()-1, b = sc.nextInt()-1;
            uf.union(a, b);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (uf.flag[i] && Math.abs(uf.root[i]) / 2 == 1) {
                cnt ++;
            }
        }
        System.out.println((n - cnt) / 2 * 2);
    }
}

class UnionFind {

    public int[] root;
    public int count;
    public boolean[] flag;

    public UnionFind(int size) {
        this.root = new int[size];
        this.flag = new boolean[size];
        this.count = size;
        Arrays.fill(this.root, -1);
    }


    public int find(int x) {
        if(root[x] < 0) return x;
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
            count --;
        } else {
            flag[xUnion] = true;
        }
    }

}