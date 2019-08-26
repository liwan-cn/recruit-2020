package util.util;

/**
 * 拓扑排序
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort {

    /**
     * 拓扑排序
     * @param graph 图的连接graph, 每一个元素为当前节点(index下标)指向的节点集合
     * @param inDegree 节点的入度数组
     * @return 拓扑排序的顺序. 如果长度等于节点个数则可以完成拓扑排序
     */
    public static List<Integer> topoSort(List<Integer>[] graph, int []inDegree){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
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
        }
        return res;
    }

    /**
     * 计算各节点入度并拓扑排序
     * @param graph 图的连接graph, 每一个元素为当前节点(index下标)指向的节点集合
     * @return 拓扑排序的顺序. 如果长度等于节点个数则可以完成拓扑排序
     */
    public static List<Integer> topoSort(List<Integer>[] graph){
        //计算入度
        int []inDegree = new int[graph.length];
        for (int out = 0; out < graph.length; out++) {
            for (Integer in : graph[out]) {
                inDegree[in] ++;
            }
        }
        return topoSort(graph, inDegree);
    }

    /**
     * 构建图, 并完成拓扑排序
     * @param edges 边节点列表, 每一个元素为(head, tail)
     * @param n 节点个数
     * @return 拓扑排序的顺序. 如果长度等于节点个数则可以完成拓扑排序
     */
    public static List<Integer> topoSort(List<int []> edges, int n){
        List<Integer>[] graph = TopoSort.buildGraph(edges, n);
        return topoSort(graph);
    }

    /**
     * 将边节点列表转换为一个节点的所有后继节点的形式的图结构
     * @param edges 边节点列表
     * @param n 节点个数
     * @return 一个节点的所有后继节点的形式的图结构形式的有向图
     */
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

