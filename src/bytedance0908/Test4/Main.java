package bytedance0908.Test4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        String s = sc.next();
        decodings(s, 0, "", res);

        for (String item:res){
            System.out.println(item);
        }

    }

    public static void decodings(String s, int start, String pre, List<String> res) {
        if (start >= s.length()) {
            res.add(pre);
            return;
        }
        if (s.charAt(start) == '0') return;
        else{
            decodings(s, start+1, pre + (char)('A' - 1 + s.charAt(start) - '0'), res);
            if (start + 1 < s.length() && (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start+1) <= '6'))) {
                decodings(s, start+2, pre + (char)('A' - 1 + ((s.charAt(start) - '0') * 10 + (s.charAt(start+1) - '0'))) , res);
            }
        }

    }
}
