package kuaishou0330.Test1;

import java.util.*;

public class Main {
    private static  int index = 0;
    public static void main(String[] args) {
        index = 0;
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        if (line.equals("None")){
            System.out.println("True");
            return;
        }
        String []nodes = line.split(",");
        int []values = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++){
            values[i] = Integer.valueOf(nodes[i]);
        }
        int []res = new int[nodes.length];
        inOrder(values, res, 0);
        for(int i = 1; i < res.length; i++){
            if (res[i] <= res[i-1]){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
    private static void inOrder(int []values, int []res, int s){
        if (s >= values.length) return;
        inOrder(values, res, (s<<1) + 1);
        res[index++] = values[s];
        inOrder(values, res, (s<<1) + 2);
    }
}
