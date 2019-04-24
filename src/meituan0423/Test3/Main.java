package meituan0423.Test3;

import java.util.*;

public class Main {
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
            return "{index: " + index + ", flag: " + flag  + ", start: " + start + ", eend: " + end + "}";
        }
    }
    private static List<Interval> generateIntervals(Rect [] rects){
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
    private static List<Line> generateLines(Rect [] rects){
        List<Line> lines = new ArrayList<>();
        for (Rect rect : rects){
            lines.add(new Line(rect.y1, 1, rect.x1, rect.x2));
            lines.add(new Line(rect.y2, -1, rect.x1, rect.x2));
        }
        Collections.sort(lines, (o1, o2) -> (o1.index == o2.index ? o1.flag - o2.flag : o1.index - o2.index));
        return lines;
    }
    private static int getArea(List<Interval> intervals, List<Line> lines){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Rect []rects = new Rect[n];
        while (n -- > 0){
            rects[n] = new Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        List<Interval> intervals = generateIntervals(rects);
        List<Line> lines = generateLines(rects);
        System.out.println(intervals);
        System.out.println(lines);
        System.out.println(getArea(intervals, lines));
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