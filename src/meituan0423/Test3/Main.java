package meituan0423.Test3;

import java.util.*;

/*
Solution2
 */

class Solution1 {

    static class Rect{
        int x1, y1, x2, y2;
        Rect(int x1, int y1, int x2, int y2){
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
    }

    static class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start; this.end = end;
        }
        @Override
        public String toString(){
            return "{start: " + start + ", end: " + end + "}";
        }
    }

    static class Line{
        int index, flag, start, end;
        Line(int index, int flag, int start, int end){
            this.index = index; this.flag = flag;
            this.start = start; this.end = end;
        }
        @Override
        public String toString(){
            return "{index: " + index + ", flag: " + flag  + ", start: " + start + ", end: " + end + "}";
        }
    }

    public static List<Interval> generateIntervals(Rect [] rects){
        List<Integer> xs = new ArrayList<>();
        for (Rect rect : rects){
            xs.add(rect.x1); xs.add(rect.x2);
        }
        Collections.sort(xs);
        List<Interval> intervals = new ArrayList<>();
        for (int i = 1, l = xs.size(); i < l; i++){
            if(xs.get(i) != xs.get(i-1))
                intervals.add(new Interval(xs.get(i-1), xs.get(i)));
        }
        return intervals;
    }

    public static List<Line> generateLines(Rect [] rects){
        List<Line> lines = new ArrayList<>();
        for (Rect rect : rects){
            lines.add(new Line(rect.y1, 1, rect.x1, rect.x2));
            lines.add(new Line(rect.y2, -1, rect.x1, rect.x2));
        }
        Collections.sort(lines, (o1, o2) -> (o1.index == o2.index ? o1.flag - o2.flag : o1.index - o2.index));
        return lines;
    }

    public static int getArea(List<Interval> intervals, List<Line> lines){
        int res = 0;
        for (Interval interval : intervals){
            int cnt = 0;
            int last = 0;
            for (Line line : lines){
                if (line.start <= interval.start && line.end >= interval.end){
                    if (cnt > 0)
                        res += (interval.end - interval.start) * (line.index - last);
                    cnt += line.flag;
                    last = line.index;
                }

            }
        }
        return res;
    }


}

/*
Solution2
 */
class Solution2 {

    static class Rect{
        int x1, y1, x2, y2;
        Rect(int x1, int y1, int x2, int y2){
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
    }

    static class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start; this.end = end;
        }
    }

    static class Node{
        int index;
        boolean isEnd;
        Interval interval;
        Node(int index, boolean isEnd, Interval interval){
            this.index = index; this.isEnd = isEnd;
            this.interval = interval;
        }
    }

    public static List<Node> generateNodes(Rect [] rects){
        List<Node> nodes = new ArrayList<>();
        for (Rect rect : rects){
            Interval interval = new Interval(rect.y1, rect.y2);
            nodes.add(new Node(rect.x1, false, interval));
            nodes.add(new Node(rect.x2, true, interval));
        }
        Collections.sort(nodes, ((o1, o2) -> (o1.index - o2.index)));
        return nodes;
    }

    public static int getIntervalsLen(List<Interval> intervals){
        int len = 0;
        Collections.sort(intervals, ((o1, o2) -> (o1.start - o2.start)));
        int preEnd = -1;
        for (Interval now : intervals){
            if (preEnd == -1 || now.start > preEnd){
                len += now.end - now.start;
                preEnd = now.end;
            } else if (now.end > preEnd){
                len += now.end - preEnd;
                preEnd = now.end;
            }
        }
        return len;
    }

    public static int getArea(List<Node> nodes){
        List<Interval> intervals = new ArrayList<>();
        long res = 0;
        int preIndex = 0;
        for (Node node : nodes){
            if (preIndex != node.index) {
                res = (res + (long)getIntervalsLen(intervals) * (long)(node.index - preIndex)) % MOD;
                preIndex = node.index;
            }
            if(node.isEnd) intervals.remove(node.interval);
            else intervals.add(node.interval);

        }
        return (int)res;
    }

    public static final int MOD = 1000000007;

}

public class Main{
    public static void main(String[] args) {

    }

    public static void test1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution1.Rect[]rects = new Solution1.Rect[n];
        while (n -- > 0){
            rects[n] = new Solution1.Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        List<Solution1.Interval> intervals = Solution1.generateIntervals(rects);
        List<Solution1.Line> lines = Solution1.generateLines(rects);
        System.out.println(intervals);
        System.out.println(lines);
        System.out.println(Solution1.getArea(intervals, lines));
    }

    public static void test2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution2.Rect []rects = new Solution2.Rect[n];
        while (n -- > 0){
            rects[n] = new Solution2.Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        List<Solution2.Node> nodes = Solution2.generateNodes(rects);
        System.out.println(Solution2.getArea(nodes));
    }
}

/*
3
0 0 2 2
1 1 3 3
0 0 3 3

2
0 0 2 2
1 1 3 3

2
0 0 2 2
2 2 3 3

2
0 0 2 2
2 1 3 3

3
0 0 1 2
0 1 1 3
0 1 1 4

3
0 0 1 2
0 1 1 3
0 2 2 4
 */