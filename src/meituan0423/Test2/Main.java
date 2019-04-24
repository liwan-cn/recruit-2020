package meituan0423.Test2;

import java.util.*;

public class Main {

    static class Line {
        int index;
        List<Interval> list = null;
        Line(int index, List<Interval> list){
            this.index = index;
            this.list = list;
        }
    }

    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString(){
            return "{start: " + start + ", end: " + end + "}";
        }
    }

    private static void addInterval(Map<Integer, List<Interval>> map, int key, int t1, int t2){
        if (!map.containsKey(key)){
            List<Interval> list = new ArrayList<>();
            list.add(new Interval(Math.min(t1, t2), Math.max(t1, t2)));
            map.put(key, list);
        } else {
            map.get(key).add(new Interval(Math.min(t1, t2), Math.max(t1, t2)));
        }
    }

    private static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for (Interval now : intervals){
            if (prev == null || now.start > prev.end){
                res.add(now);
                prev = now;
            } else if (now.end > prev.end){
                prev.end = now.end;
            }
        }
        return res;
    }

    private static List<Line> generateLine(Map<Integer, List<Interval>> map){
        List<Line> lines = new ArrayList<>();
        for (Map.Entry<Integer, List<Interval>> e : map.entrySet()){
            lines.add(new Line(e.getKey(), merge(e.getValue())));
        }
        Collections.sort(lines, (o1, o2) -> (o1.index - o2.index));
        return lines;
    }

    private static int getPointCount(List<Line> lines){
        int cnt = 0;
        for (Line line : lines){
            for (Interval item : line.list){
                cnt += item.end - item.start + 1;
            }
        }
        return cnt;
    }

    private static int getCrossPointCount(List<Line> rowLines, List<Line> colLines){
        int cnt = 0;
        for (Line rowLine : rowLines){
            int i = 0, j = 0;
            List<Interval> list = rowLine.list;
            while (i < list.size() && j < colLines.size()){
                int colIndex = colLines.get(j).index;
                int rowStart = list.get(i).start, rowEnd = list.get(i).end;
                if (colIndex >= rowStart && colIndex <= rowEnd){
                    if (isCross(rowLine.index, colLines.get(j).list)) {
                        cnt ++;
                    }
                    j ++;
                } else if (colIndex < rowStart){
                    j ++;
                } else {
                    i ++;
                }
            }
        }
        return cnt;
    }

    private static boolean isCross(int index, List<Interval> list){
        int s = 0, e = list.size() - 1;
        while (s < e) {
            int m = (s + e) >> 1;
            Interval interval = list.get(m);
            if (index >= interval.start && index <= interval.end) return true;
            if (index < interval.start) e = m - 1;
            else s = m + 1;
        }
        return (index >= list.get(s).start && index <= list.get(s).end);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Interval>> rowMap = new HashMap<>();
        Map<Integer, List<Interval>> colMap = new HashMap<>();
        while(n-- > 0){
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            if (x1 == x2){
                addInterval(rowMap, x1, y1, y2);
            }else if(y1 == y2) {
                addInterval(colMap, y1, x1, x2);
            }
        }
        System.out.println(rowMap);
        System.out.println(colMap);
        List<Line> rowLines = generateLine(rowMap);
        List<Line> colLines = generateLine(colMap);

        int pointCount = getPointCount(rowLines) + getPointCount(colLines);

        int crossPointCount = getCrossPointCount(rowLines, colLines);

//        System.out.println(pointCount);
//        System.out.println(crossPointCount);
        System.out.println(pointCount - crossPointCount);
    }
}

/*
4
1 2 2 2
2 2 3 2
3 1 3 2
3 2 3 3
*/
