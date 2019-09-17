package qianxin0909.Test2;

import java.util.*;
class UnionFind {

    private int[] root;
    private int count;

    public UnionFind(int size) {
        //初始化个数
        //初始化数组，每个并查集都指向自己
        this.root = new int[size];
        this.count = size;
        Arrays.fill(this.root, -1);
    }

    public int count() {
        return count;
    }

    public int[] getRoot() {
        return root;
    }

    public int find(int x) {
        if(root[x] < 0) return x;
        return root[x] = find(root[x]);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        //找出x所在的集合
        int xUnion = find(x);
        //找出y所在的集合
        int yUnion = find(y);

        //如果这两个不是同一个集合，那么合并。
        if (xUnion != yUnion) {
            if (root[xUnion] > root[yUnion]) {
                root[yUnion] += root[xUnion];
                root[xUnion] = yUnion;
            } else {
                root[xUnion] += root[yUnion];
                root[yUnion] = xUnion;

            }
            count --;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                int t = sc.nextInt();
                if (i < j && t == 1) {
                    uf.union(i, j);
                }
            }
        }
        List<Integer> init = new ArrayList<>();
        while (sc.hasNextInt()) {
            init.add(sc.nextInt());
        }
        Collections.sort(init);
        int res = init.get(0), max = 0;
        for (int i = 0; i < init.size(); i++) {
            boolean f = false;
            for (int j = 0; j < init.size(); j++) {
                if (i != j) {
                    if(uf.isConnected(init.get(i), init.get(j))){
                        f = true;
                    }
                }
            }
            if (!f && max < uf.getRoot()[uf.find(init.get(i))]) {
                max = uf.getRoot()[uf.find(i)];
                res = init.get(i);
            }
        }
        System.out.println(res);
    }
}
