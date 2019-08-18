package xiaohongshu0818.Test1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String []strs = str.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = strs.length-1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            else res.add(strs[i]);
        }
        for (int i = 0; i < res.size(); i++) {
            if (i == 0) System.out.print(res.get(i));
            else System.out.print(" " + res.get(i));
        }
        System.out.println();
    }
}
