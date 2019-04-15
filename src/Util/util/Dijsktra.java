package Util.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijsktra {
    static class Path{
        public int distance = 0;
        public  List<Integer> path = null;//记录起始点到各定点的最短路径
        public Path(){
            distance = -1;
            path = new ArrayList<>();
        }
        @Override
        public String toString(){
            return "distance: " + distance + ", path: " + path.toString();
        }
    }
    public static Path[] dijsktra(int [][] weight, int start){
        //自己到自己的距离为 0, 如果两个节点不直接连通为 -1
        int nodeCount = weight.length; //获取顶点个数
        Path []shortPath = new Path[nodeCount]; //最短路径数组
        for (int i = 0; i < nodeCount; i++){
            shortPath[i] = new Path();
        }
        boolean []visited = new boolean[nodeCount];
        shortPath[start].distance = 0;
        shortPath[start].path.add(start);
        visited[start] = true;
        for(int m = 1, now = start; m < nodeCount; m++) {
            int min = Integer.MAX_VALUE, minNode = -1;
            for (int i = 0; i < nodeCount; i++) {
                if (!visited[i] && weight[now][i] != -1 &&
                        (shortPath[i].distance == -1 ||
                                shortPath[now].distance + weight[now][i] < shortPath[i].distance)) {
                    shortPath[i].distance = shortPath[now].distance + weight[now][i];
                    shortPath[i].path = new ArrayList<>(shortPath[now].path);
                    shortPath[i].path.add(i);
                }
                if (!visited[i] && shortPath[i].distance != -1 && min > shortPath[i].distance){
                    min = shortPath[i].distance;
                    minNode = i;
                }
            }
            now = minNode;
            visited[now] = true;
        }
        return shortPath;
    }
}