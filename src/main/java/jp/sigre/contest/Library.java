package jp.sigre.contest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * よく使うであろう解法を事前に作成しておく
 */
public class Library {

    /**
     * しゃくとり法
     *
     * @param ints
     * @return
     */
    private static long shakutori(int[] ints) {
        long result = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < ints.length; i++) {
            int num = ints[i];

            deque.add(num);
            int left = 0;
            while (left == 0) {

                if (deque.peekLast() == null) {
                    break;
                }
                left = deque.pollFirst();
            }
        }

        return result;
    }

    /**
     * DP法(ナップサック問題)
     *
     * @param n 石の種類
     * @param w 最大重量
     */
    private static void dp(Scanner sc, int n, int w) {
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
