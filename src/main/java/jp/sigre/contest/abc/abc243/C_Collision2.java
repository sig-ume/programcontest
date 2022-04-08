package jp.sigre.contest.abc.abc243;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C_Collision2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int paramCount = sc.nextInt();
        List<Point> points = getPoints(sc, paramCount).stream().sorted().collect(Collectors.toList());
//        List<Point> points = new ArrayList<>();
//        points.add(new Point(2,1, "R"));
//        points.add(new Point(1,1, "R"));

        String result = "No";
        while (points.size() >= 2) {
            List<Point> sameYList = getSameYList(points);
            if (checkCrashInList(sameYList)) {
                result = "Yes";
                break;
            }
            points = points.subList(sameYList.size(), points.size());
        }

        System.out.println(result);
    }

    private static List<Point> getSameYList(List<Point> points) {
        Point firstPoint = points.get(0);
        List<Point> sameYPoints = new ArrayList<>();
        sameYPoints.add(firstPoint);
        for (int i = 1; i < points.size(); i++) {
            Point point = points.get(i);
            if(!sameY(firstPoint, point))  break;
            sameYPoints.add(point);
        }

        return sameYPoints;
    }

    private static List<Point> getPoints(Scanner sc, int paramCount) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < paramCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y, ""));
        }

        String directions = sc.next();
        for (int i = 0; i < paramCount; i++) {
            points.get(i).setDirection(String.valueOf(directions.charAt(i)));
            //System.out.println(points.get(i));
        }
        
        return points;
    }

    private static boolean checkCrashInList(List<Point> points) {
        if(1 >= points.size()) return false;
        // 同じYをもつPointが大量にある場合に処理量が増える
//        for (int i = 0; i < points.size(); i++) {
//            for (int j = i + 1; j < points.size(); j++) {
//                if (checkCrash(points.get(i), points.get(j))) return true;
//            }
//        }
        Point[] leftRight = getLeftRight(points);
        return checkCrash(leftRight[0], leftRight[1]);
    }

    private static Point[] getLeftRight(List<Point> points) {
        Point left = new Point(1000000001, 0, "X");
        Point right = new Point(-1, 0, "X");
        for (Point point : points) {
            if (point.isR() && point.x <= left.x) left = point;
            if (point.isL() && right.x <= point.x) right = point;
        }

        return new Point[]{left, right};
    }

    private static boolean checkCrash(Point p1, Point p2) {
        if (!p1.isCorrectDirection() || !p2.isCorrectDirection()) return false;
        if (!sameY(p1, p2)) return false;
        if (p1.x < p2.x && p1.isR() && p2.isL()) return true;
        if (p2.x < p1.x && p2.isR() && p1.isL()) return true;
        return false;
    }

    private static boolean sameY(Point p1, Point p2) {
        return p1.y == p2.y;
    }

    private static class Point implements Comparable<Point>{
        int x;
        int y;
        String direction;

        private Point(int x, int y, String direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public int compareTo(Point point) {
            return this.y - point.y;
        }

        public boolean isL() {
            return direction.equals("L");
        }

        public boolean isR() {
            return direction.equals("R");
        }

        public boolean isCorrectDirection() {
            return isL() || isR();
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction='" + direction + '\'' +
                    '}';
        }
    }
}
