package util;

import util.util.Comb;
import util.util.Dijsktra;

import java.util.*;

import static util.util.TopoSort.topoSort;

class Solution {
    public int maxSubMatrix(int[][] mat) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int []nums = new int[mat[i].length];
            for (int h = 0; h <= i; h++) {
                int preSum = Integer.MIN_VALUE;
                for (int j = 0; j < mat[i].length; j++) {
                    nums[j] += mat[i-h][j];
                    if (preSum > 0){
                        preSum += nums[j];
                    } else {
                        preSum = nums[j];
                    }
                    max = Math.max(max, preSum);
                }
            }
        }
        return max;
    }
}


class Solution2 {
    public int[] rawSeq(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int []raw = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            q.offer(i);
        }
        int index = 0;
        while (!q.isEmpty()) {
            raw[q.poll()] = nums[index++];
            if (!q.isEmpty()){
                q.offer(q.poll());
            }
        }
        return raw;
    }
}

public class Test {
    public static void main(String[] args) {
        int [][]mat = new int[][]{{1,2,-4}, {4,5,-2}, {1, -1, 3}};
        System.out.println(new Solution().maxSubMatrix(mat));
        System.out.println(Arrays.toString(new Solution2().rawSeq(new int[]{1, 2, 3, 4, 5})));
        //testTopoSort();
        //testComb();
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
        List<Integer> res = new ArrayList<>();
        //List<Integer>[] graph = TopoSort.buildGraph(edges, 5);
        //System.out.println(topoSort(graph, res));
        System.out.println(topoSort(edges, 5, res));
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
