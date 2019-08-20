package bilibili0820.Test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String []strs = line.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                if ((strs[i].length() & 1) == 0) {
                    System.out.print(strs[i]);
                } else {
                    System.out.print(new StringBuilder(strs[i]).reverse());
                }
            } else {
                if ((strs[i].length() & 1) == 0) {
                    System.out.print(" " + strs[i]);
                } else {
                    System.out.print(" " + new StringBuilder(strs[i]).reverse());
                }
            }
        }
        System.out.println();
    }
}
