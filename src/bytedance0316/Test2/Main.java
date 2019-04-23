package bytedance0316.Test2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0){
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i  = 0, l = s.length(), index = 0; i < l; i++){
                if (i < 2) {
                    sb.append(s.charAt(i));
                    index ++;
                }
                if (i >= 2){
                    if (s.charAt(i) == sb.charAt(index-1) && s.charAt(i) == sb.charAt(index-2)){
                        continue;
                    }
//                    System.out.println(sb);
//                    System.out.println(i);
//                    System.out.println(index);
                    if (index >= 3 && s.charAt(i) == sb.charAt(index-1) && sb.charAt(index-3) == sb.charAt(index-2)){
                        continue;
                    }
                    sb.append(s.charAt(i));
                    index ++;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
