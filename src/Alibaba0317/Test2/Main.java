package Alibaba0317.Test2;

import java.util.*;


public class Main {
    public static class Node{
        double value;
        int index;
        public Node(double value, int index){
            this.value = value;
            this.index = index;
        }
        public double getValue(){
            return this.value;
        }
    }
    public static void main(String[] args) {
        // write your code here

        double [][]raw = {{0.2, 1000, 0.002},{0.3, 2000, 0.003},{0.2, 3000, 0.001}};
        int [][]res =  transWithoutMap(raw);
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[i].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] transWithMap(double[][] raw){
        Map<Double, Integer> map = new HashMap<>();
        double[] tmp = new double[raw[0].length];
        int [][]res = new int[raw.length][raw[0].length];
        for (int i = 0; i < raw[0].length; i++){
            for (int j = 0; j < raw.length; j++){
                tmp[j] = raw[j][i];
            }
            Arrays.sort(tmp);
            map.clear();
            for (int j = 0; j < tmp.length; j++){
                map.put(tmp[j], map.getOrDefault(tmp[j], map.size()));
            }
            for (int j = 0; j < raw.length; j++){
                res[j][i] = map.get(raw[j][i]);
            }
        }
        return res;
    }
    private static int[][] transWithoutMap(double[][] raw){
        Node[] tmp = new Node[raw[0].length];
        int [][]res = new int[raw.length][raw[0].length];
        for (int i = 0; i < raw[0].length; i++){
            for (int j = 0; j < raw.length; j++){
                tmp[j] = new Node(raw[j][i], j);
            }
            //Arrays.sort(tmp, Comparator.comparing(Node::getValue));
            Arrays.sort(tmp, (o1, o2)->Double.compare(o1.value, o2.value));

            int index = -1;

            for (int j = 0; j < tmp.length; j++){

                if (j ==0 || tmp[j].value != tmp[j-1].value) {
                    index++;
                }
                res[tmp[j].index][i] = index;

            }
        }
        return res;
    }
}
