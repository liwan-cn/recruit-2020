package Util;

import Util.util.Comb;
import Util.util.Dijsktra;
import Util.util.TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Util.util.TopoSort.topoSort;

public class Test {
    public static void main(String[] args) {
        testComb();
    }
    public static void testTopoSort() {
        List<int []> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{0, 2});
        edges.add(new int[]{1, 3});
        edges.add(new int[]{3, 2});
        edges.add(new int[]{4, 3});
        edges.add(new int[]{2, 4});
        //edges.add(new int[]{0, 1});
        List<Integer> res = new ArrayList<>();
        List<Integer>[] graph = TopoSort.buildGraph(edges, 5);
        System.out.println(topoSort(graph, res));
        System.out.println(res);
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
}
