package other;

import java.util.*;
/*
给定字符串, 和词典, 把字符串中所有在词典中的词删除
 */

public class FilterDict {
    public static void main(String[] args) {
        String str = "最新款欧美风连衣裙x连衣裙雪纺";
        String []filterDict = {"新款", "最新款"};
        System.out.println(getShort(str, filterDict));
    }
    public static String getShort(String str,  String [] filterDict) {
        Set<String> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE, minLen =  Integer.MAX_VALUE;
        for (String s: filterDict) {
            set.add(s);
            maxLen = Math.max(maxLen, s.length());
            minLen = Math.min(minLen, s.length());
        }
        List<int[]> delete = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int l = maxLen; l >= minLen; l--) {
                if (i + l <= str.length() && set.contains(str.substring(i, i + l))){
                    delete.add(new int[]{i, i + l - 1});
                    break;
                }
            }
        }
        boolean[] flag = new boolean[str.length()];
        for (int[] q : delete) {
            for (int i = q[0]; i <= q[1]; i++){
                flag[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!flag[i]) sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}