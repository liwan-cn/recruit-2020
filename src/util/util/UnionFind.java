package util.util;

/**
 * 并查集, 路径压缩和union优化
 */

import java.util.Arrays;

public class UnionFind {

    /**
     * 并查集根节点指针数组
     * 当值小于0时, abs(root[i])为所在连通图节点个数
     * 当值大于0时, root[i]为该节点的根节点(一个连通图中的根节点可以是任何节点)
     */
    private int[] root;

    /**
     * 连通图的个数
     */
    private int count;

    /**
     * 并查集构造函数
     * @param size 节点个数
     */
    public UnionFind(int size) {
        //初始化个数
        //初始化数组，每个并查集都指向自己
        this.root = new int[size];
        this.count = size;
        Arrays.fill(this.root, -1);
    }

    /**
     * 连通图的个数
     * @return 连通图的个数
     */
    public int count() {
        return count;
    }

    public int[] getRoot() {
        return root;
    }

    /**
     * 查找节点所在连通图的根节点, 并在查找过程中完成路径压缩
     * @param x 待查找的节点
     * @return 节点所在连通图的根节点
     */
    private int find(int x) {
        if(root[x] < 0) return x;
        return root[x] = find(root[x]);
    }

    /**
     * 判断两个节点是不是在同一个连通图中
     * @param x 待查找的节点
     * @param y 待查找的节点
     * @return true or false 两个节点是不是在同一个连通图中
     */
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 将两个节点合并到同一个连通图中(即将两个连通图合并)
     * @param x 待合并节点
     * @param y 待合并节点
     */
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