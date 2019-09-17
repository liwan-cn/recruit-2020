package shopee0914.Test2;

/*
第一个只出现一次的字符
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            int []m = new int[256];
            for (int i = 0; i < line.length(); i++) {
                m[line.charAt(i)] ++;
            }
            boolean f = false;
            for (int i = 0; i < line.length(); i++) {
                if (m[line.charAt(i)] == 1) {
                    System.out.println((char)(line.charAt(i)));
                    f = true;
                    break;
                }
            }
            if (!f) System.out.println(-1);
        }

    }
}
