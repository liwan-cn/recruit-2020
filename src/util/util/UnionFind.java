package util.util;

import java.util.Arrays;

public class UnionFind {

    private int[] root;
    private int count;

    public UnionFind(int size) {
        //初始化个数
        //初始化数组，每个并查集都指向自己
        this.root = new int[size];
        this.count = size;
        Arrays.fill(this.root, -1);
    }

    private int count() {
        return count;
    }

    private int find(int x) {
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

    private void print(int[] arr){
        for(int p : arr){
            System.out.print(p+"\t");
        }
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print(find(i)+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind union = new UnionFind(n);

        System.out.println("初始parent：");
        union.print(union.root);

        System.out.println("连接了5 6 之后的parent：");
        union.union(5, 6);
        union.print(union.root);

        System.out.println("连接了1 2 之后的parent：");
        union.union(1, 2);
        union.print(union.root);

        System.out.println("连接了2 3 之后的parent：");
        union.union(2, 3);
        union.print(union.root);

        System.out.println("连接了1 4 之后的parent：");
        union.union(1, 4);
        union.print(union.root);


        System.out.println("连接了1 5 之后的parent：");
        union.union(1, 5);
        union.print(union.root);


        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }

}