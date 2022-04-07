package jp.sigre.contest.abc.abc086.c_traveling;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Point start = new Point(0, 0);
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            int tx = sc.nextInt();
            int t = tx - endTime;
            int x = sc.nextInt();
            int y = sc.nextInt();

            boolean isGoal = travel(start.x, start.y, x, y, t);
            if (!isGoal) {
                System.out.println("No");
                return;
            }

            start = new Point(x, y);
            endTime = tx;
        }
        System.out.println("Yes");
    }

    private static boolean travel(int startX, int startY, int goalX, int goalY, int time) {
        int distance = Math.abs(goalX - startX) + Math.abs(goalY - startY);
        if (distance > time) return false;
        if (distance % 2 != time % 2) return false;

        return true;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
