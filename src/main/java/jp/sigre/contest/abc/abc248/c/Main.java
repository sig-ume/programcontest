package jp.sigre.contest.abc.abc248.c;

import java.util.Scanner;

public class Main {
    private static class C {
        long res;
        int N;
        int M;
        int K;
        long[][] memo;
        int border = 998244353;

        public long m() {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            memo = new long[N + 1][K + 1];
            memo[0][0] = 1;

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= K; j++) {
                    dp(i, j);
                }
            }

            for (int i = 0; i <= K; i++) {
                res += memo[N][i];
                if (res >= border) res -= border;
            }

            return res;
        }

        private void dp(int i, int sum) {
            for (int j = 1; j <= M; j++) {
                if (i + 1 <= N && sum + j <= K) {
                    memo[i + 1][sum + j] += memo[i][sum];
                    if (memo[i + 1][sum + j] >= border) {
                        memo[i + 1][sum + j] -= border;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new C().m());
    }
}