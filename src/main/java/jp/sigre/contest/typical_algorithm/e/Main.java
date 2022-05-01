package jp.sigre.contest.typical_algorithm.e;

import java.util.Scanner;

/**
 * 全点対最短経路(ワーシャルフロイド)
 */
public class Main {

    static long INF = 1000000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = i == j ? 0 : INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int v0 = sc.nextInt();
            int v1 = sc.nextInt();
            long c = sc.nextInt();
            dp[v0][v1] = c;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
            }
        }

        System.out.println(result);
    }
}