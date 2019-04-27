package meituan0423.Test3;

import java.util.*;

/*
Solution2
 */

public class Main {

    @Deprecated
    static class Rect{
        int x1, y1, x2, y2;
        Rect(int x1, int y1, int x2, int y2){
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
    }

    public static final int MOD = 1000000009;

    //for solution 1
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

    //for solution 1
    public static List<Integer> generateXs(int [][] rects){
        List<Integer> xs = new ArrayList<>();
        for (int []rect : rects){
            xs.add(rect[0]); xs.add(rect[2]);
        }
        Collections.sort(xs);
        return xs;
    }

    //for solution 1
    public static List<Line> generateLines(int [][] rects){
        List<Line> lines = new ArrayList<>();
        for (int[] rect : rects){
            lines.add(new Line(rect[1], 1, rect[0], rect[2]));
            lines.add(new Line(rect[3], -1, rect[0], rect[2]));
        }
        Collections.sort(lines, (o1, o2) -> (o1.index == o2.index ? o1.flag - o2.flag : o1.index - o2.index));
        return lines;
    }

    //for solution 1
    public static int getArea(List<Integer> xs, List<Line> lines){
        int res = 0;
        int preX = 0;
        for (int nowX : xs){
            int cnt = 0;
            int lastY = 0;
            if (nowX != preX){
                for (Line line : lines){
                    if (line.start <= preX && line.end >= nowX){
                        if (cnt > 0)
                            res = res + (nowX - preX) * (line.index - lastY);
                        cnt += line.flag;
                        lastY = line.index;
                    }
                }
                preX = nowX;
            }
        }
        return res;
    }

    //for solution 2
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

    //for solution 2
    static class Node{
        int index;
        boolean isEnd;
        Interval interval;
        Node(int index, boolean isEnd, Interval interval){
            this.index = index; this.isEnd = isEnd;
            this.interval = interval;
        }
    }

    //for solution 2
    public static List<Node> generateNodes(int [][] rects){
        List<Node> nodes = new ArrayList<>();
        for (int[] rect : rects){
            Interval interval = new Interval(rect[1], rect[3]);
            nodes.add(new Node(rect[0], false, interval));
            nodes.add(new Node(rect[2], true, interval));
        }
        Collections.sort(nodes, ((o1, o2) -> (o1.index - o2.index)));
        return nodes;
    }

    //for solution 2
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

    //for solution 2
    public static int getArea(List<Node> nodes){
        List<Interval> intervals = new ArrayList<>();
        int res = 0;
        int preX = 0;
        for (Node node : nodes){
            if (preX != node.index) {
                res = res + getIntervalsLen(intervals) * (node.index - preX);
                preX = node.index;
            }
            if(node.isEnd) intervals.remove(node.interval);
            else intervals.add(node.interval);

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rects = new int[n][4];
        while (n -- > 0){
            rects[n][0] = sc.nextInt();
            rects[n][1] = sc.nextInt();
            rects[n][2] = sc.nextInt();
            rects[n][3] = sc.nextInt();
        }
        test1(rects);
        test2(rects);
    }

    public static void test1(int [][] rects){
        List<Integer> xs = generateXs(rects);
        List<Line> lines = generateLines(rects);
        System.out.println(lines);
        System.out.println(getArea(xs, lines));
    }

    public static void test2(int [][] rects){
        List<Node> nodes = generateNodes(rects);
        System.out.println(getArea(nodes));
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