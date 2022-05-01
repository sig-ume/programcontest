package jp.sigre.contest.typical_algorithm.c;

import java.util.Scanner;

/**
 * 巡回セールスマン(bit DP)
 */
public class Main {
    static long[][] memo;
    static long[][] roads;
    static int n = 0;
    private static final long INF = 13000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        roads = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roads[i][j] = sc.nextLong();
            }
        }

        memo = new long[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                memo[i][j] = INF;
            }
        }
        memo[0][0] = 0;

        int allDone = (1 << n) - 1;

        System.out.println(calc(0, allDone));
    }

    private static long calc(int now, int s) {
        if (memo[now][s] != INF) return memo[now][s];

        if (now == 0 && s != 0 && s != (1 << n) - 1) return INF;
        if (((1 << now) & s) == 0) return INF;

        long min = INF;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, calc(i, s ^ (1 << now)) + roads[i][now]);
        }

        return memo[now][s] = min;
    }
}
