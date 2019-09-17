package zhaoshang0915;

import java.util.*;

public class LR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int []neighbor = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty()){
                    neighbor[stack.peek()] = i - stack.pop();
                }
            }
        }
        stack.clear();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == 'L') {
                stack.push(i);
            } else {
                while (!stack.isEmpty()){
                    neighbor[stack.peek()] = i - stack.pop();
                }
            }
        }

        int []res = new int[s.length()];
        for (int i = 0; i < neighbor.length; i++) {
            if (neighbor[i] != 0) {
                if (neighbor[i] > 0 && Math.abs(neighbor[i]) % 2 == 1) {
                    res[neighbor[i] + i - 1] ++;
                } else if (neighbor[i] > 0){
                    res[neighbor[i] + i] ++;
                } else if ( Math.abs(neighbor[i]) % 2 == 1) {
                    res[neighbor[i] + i + 1] ++;
                }else {
                    res[neighbor[i] + i] ++;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(res[i]);

        }
        System.out.println();
    }
}
