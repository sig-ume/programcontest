package jp.sigre.contest.education_dp_contest.c_vacation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] points = new int[n][3];
        points[0][0] = sc.nextInt();
        points[0][1] = sc.nextInt();
        points[0][2] = sc.nextInt();

        for(int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            calcPoint(points, i, a, b, c);
        }

        int lastA = points[points.length - 1][0];
        int lastB = points[points.length - 1][1];
        int lastC = points[points.length - 1][2];

        System.out.println(Math.max(Math.max(lastA, lastB), lastC));
    }

    private static void calcPoint(int[][] points, int i, int a, int b, int c) {
        int befA = points[i-1][0];
        int befB = points[i-1][1];
        int befC = points[i-1][2];

        points[i][0] = Math.max(befB + a, befC + a);
        points[i][1] = Math.max(befA + b, befC + b);
        points[i][2] = Math.max(befA + c, befB + c);
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
