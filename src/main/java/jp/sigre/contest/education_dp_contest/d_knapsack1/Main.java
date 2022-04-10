package jp.sigre.contest.education_dp_contest.d_knapsack1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        long[][] memo = new long[n + 1][w + 1];

        Stone[] stones = new Stone[n];
        for (int i = 0; i < n; i++) {
            stones[i] = new Stone(sc.nextInt(), sc.nextInt());
        }

        for (int tN = n; tN >= 0; tN--) {
            for (int tW = w; tW >= 0; tW--) {
                if (tN >= n) {
                    memo[tN][tW] = 0;
                    continue;
                }

                Stone stone = stones[tN];
                long valueOfIn = w >= tW + stone.weight ? memo[tN + 1][tW + stone.weight] + stone.value : -1;
                long valueOfNotIn = memo[tN + 1][tW];
                memo[tN][tW] = Math.max(valueOfNotIn, valueOfIn);
            }
        }

        System.out.println(memo[0][0]);
    }

    private static class Stone {
        int weight;
        long value;

        public Stone(int weight, long value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
