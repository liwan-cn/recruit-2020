package util.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort {
    public static boolean topoSort(List<Integer>[] graph, int []inDegree, List<Integer> res){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        //int count = 0;
        while (!queue.isEmpty()){
            int out = queue.poll();
            res.add(out);
            //count ++;
            for (int in : graph[out])
                if(--inDegree[in] == 0){
                    queue.offer(in);
                }

        }
        if (res.size() != inDegree.length){
            res.clear();
            return false;
        }
        return true;

    }
    public static boolean topoSort(List<Integer>[] graph, List<Integer> res){
        //计算入度
        int []inDegree = new int[graph.length];
        for (int out = 0; out < graph.length; out++) {
            for (Integer in : graph[out]) {
                inDegree[in] ++;
            }
        }
        return topoSort(graph, inDegree, res);
    }

    public static boolean topoSort(List<int []> edges, int n, List<Integer> res){
        List<Integer>[] graph = TopoSort.buildGraph(edges, n);
        return topoSort(graph, res);
    }

    public static List<Integer>[] buildGraph(List<int []> edges, int n){
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }
}

