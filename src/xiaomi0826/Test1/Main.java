package xiaomi0826.Test1;

/**
 * ip地址统计
 */

import java.util.*;

public class Main {

    static class IpRange{
        long start, end;
        int pId;
        public IpRange(long start, long end,int pId) {
            this.start = start;
            this.end = end;
            this.pId = pId;
        }
        @Override
        public String toString(){
            return start + ", "  + end + ", " + pId;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            TreeMap<Long, IpRange> map = new TreeMap<>();
            Map<Integer, Integer> res = new HashMap<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                long start = ip2Long(sc.next());
                long end = ip2Long(sc.next());
                int pId = sc.nextInt();
                IpRange ir = new IpRange(start, end, pId);
                map.put(start, ir);
                res.put(pId, 0);
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                long ip = ip2Long(sc.next());
                Map.Entry<Long, IpRange> e = map.floorEntry(ip);
                if (e != null) {
                    IpRange ir = e.getValue();
                    if (ip >= ir.start && ip <= ir.end) {
                        res.put(ir.pId, res.getOrDefault(ir.pId, 0) + 1);
                    }
                }
            }

            List<Integer> pIds = new ArrayList<>(res.keySet());
            Collections.sort(pIds);
            for (int i : pIds) {
                System.out.println(i + " " + res.get(i));
            }
        }
    }
    private static long ip2Long(String ip) {
        String []items = ip.split("\\.");
        long res = 0;
        for (String item : items) {
            res = (res << 8) + Integer.valueOf(item);
        }
        //System.out.println(res);
        return res;
    }
}
/*
2
1
192.168.12.2 192.168.12.3 1
2
10.100.108.34
192.168.12.2
3
10.1.1.1 10.2.255.255 1
223.199.12.2 224.200.19.12 2
172.2.12.0 172.16.2.2 3
3
10.2.123.123
10.2.255.255
223.199.13.255
 */