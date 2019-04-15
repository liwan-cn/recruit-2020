package Tencent0310.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        for (int i =1; i <= n; i++){
            queue.offer(i);
        }
        //System.out.println(n);
        boolean flag = true;
        while(!queue.isEmpty()){
            if (flag){
                System.out.print(queue.poll());
                flag = false;
            }else{
                System.out.print(" " + queue.poll());
            }

            if(!queue.isEmpty()){
                queue.offer(queue.poll());
            }
        }
        System.out.println();
    }
}
