package util;

import util.util.*;
import java.util.*;


public class Test {
    public static void main(String[] args) {
        testTopoSort();
        //testComb();
    }

    public static void testPrimeSieve() {
        PrimeSieve ps = new PrimeSieve();
        for (int i = 100; i < 3000; i++) {
            System.out.print(i + "\t");
            System.out.println(ps.primeFactors(i));
        }
    }

    private static void print(int[] arr){
        for(int p : arr){
            System.out.print(p+"\t");
        }
        System.out.println();
    }

    public static void testUnionFind(String[] args) {
        int n = 10;
        UnionFind union = new UnionFind(n);

        System.out.println("初始parent：");
        print(union.getRoot());

        System.out.println("连接了5 6 之后的parent：");
        union.union(5, 6);
        print(union.getRoot());

        System.out.println("连接了1 2 之后的parent：");
        union.union(1, 2);
        print(union.getRoot());

        System.out.println("连接了2 3 之后的parent：");
        union.union(2, 3);
        print(union.getRoot());

        System.out.println("连接了1 4 之后的parent：");
        union.union(1, 4);
        print(union.getRoot());


        System.out.println("连接了1 5 之后的parent：");
        union.union(1, 5);
        print(union.getRoot());


        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }

    public static void testTopoSort() {
        List<int []> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{0, 2});
        edges.add(new int[]{1, 3});
        edges.add(new int[]{3, 2});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{2, 4});
        //edges.add(new int[]{0, 1});
        //List<Integer>[] graph = TopoSort.buildGraph(edges, 5);
        //System.out.println(topoSort(graph, res));
        System.out.println(TopoSort.topoSort(edges, 5));
    }

    public static void testComb(){
        //组合
        for (long []t: Comb.comb(20, 10)){
            System.out.println(Arrays.toString(t));
        }

    }

    public static void testDijsktra() {
        //迪杰斯特拉
        int [][]a = new int[4][4];
        for (int i = 0 ;i <4; i++){
            for (int j = 0; j < 4; j++){
                a[i][j] = -1;
            }
            a[i][i] = 0;
        }
        a[0][1] = 5;a[0][3] = 7;
        a[1][2] = 4;a[1][3] = 2;
        a[2][0] = 3;a[2][1] = 3;a[2][3] = 2;
        a[3][2] = 1;
        for (int i = 0; i < 4; i++)
            System.out.println(i + ":" + Arrays.toString(Dijsktra.dijsktra(a, i)));
    }

    public static void testMatQuickPower() {
        int [][]a = new int[][]{{1,1}, {1, 0}};
        int [][]c = MatQuickPower.matQuickPower(a, 20000000);
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        c = a;
        for (int i = 0; i < 20000000-1; i++){
            c = MatQuickPower.matmul(c, a);
        }
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }
}
