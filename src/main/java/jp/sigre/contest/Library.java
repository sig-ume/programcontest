package jp.sigre.contest;

import java.util.*;

/**
 * よく使うであろう解法を事前に作成しておく
 */
@SuppressWarnings("unused")
public class Library {

    /**
     * しゃくとり法
     *
     * @param ints 尺取するリスト
     * @return なにか
     */
    private static long shakutori(int[] ints) {
        long result = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : ints) {
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

    /**
     * 素数リスト(エラトステネスの篩)
     * @param maxNumber 素数を求めたい最大値
     * @return 素数リスト
     */
    private static List<Integer> getPrimeArrayUnder(int maxNumber) {
        boolean[] targetNumbers = new boolean[maxNumber + 1];
        Arrays.fill(targetNumbers, true);
        targetNumbers[0] = false;
        targetNumbers[1] = false;

        // 素数リスト
        List<Integer> primeNumbers = new ArrayList<>();

        int sqrt = (int) Math.sqrt(maxNumber);

        // ステップ3：探索リストの先頭の値が、引数の平方根に達するまでふるい落とし操作を続ける。
        for (int i = 2; i <= sqrt; i++) {
            // ステップ2：探索リストの先頭の数を素数とし、その倍数を探索リストから篩い落とす。
            // ※この時、既に篩い落とされた数（false）は除外する。
            if (targetNumbers[i]) {
                for (int j = i * i; j < targetNumbers.length; j += i) {
                    targetNumbers[j] = false;
                }
            }
        }

        // ステップ4：探索リストに残った値を素数リストに移して処理終了。
        for (int i = 2; i < targetNumbers.length; i++) {
            if (targetNumbers[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    /**
     *
     * @param xs Integer配列
     * @param key 探索する値
     * @return 「指定した値以上の要素」が初めて出現した位置
     */
    private static int lowerBound(int[] xs, int key) {
        Integer[] xs2 = new Integer[xs.length];

        for (int i = 0; i < xs.length; i++) {
            xs2[i] = xs[i];
        }

        return lowerBound(xs2, key);
    }

    private static int lowerBound(Integer[] xs, int key) {
        LowerBoundComparator<Integer> lowerBoundComparator = new LowerBoundComparator<>();
        int result = Arrays.binarySearch(xs, key, lowerBoundComparator);

        return (result >= 0) ? result : ~result;
    }

    /**
     *
     * @param xs Integer配列
     * @param key 探索する値
     * @return 「指定した値より大きい要素」が初めて出現した位置
     */
    private static int upperBound(int[] xs, int key) {
        Integer[] xs2 = new Integer[xs.length];

        for (int i = 0; i < xs.length; i++) {
            xs2[i] = xs[i];
        }

        return upperBound(xs2, key);
    }

    private static int upperBound(Integer[] xs, int key) {
        UpperBoundComparator<Integer> upperBoundComparator = new UpperBoundComparator<>();
        int result = Arrays.binarySearch(xs, key, upperBoundComparator);

        return (result >= 0) ? result : ~result;
    }

    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    static class LowerBoundComparator<T extends Comparable<? super T>>
            implements Comparator<T>
    {
        public int compare(T x, T y)
        {
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
    }

    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    static class UpperBoundComparator<T extends Comparable<? super T>>
            implements Comparator<T>
    {
        public int compare(T x, T y)
        {
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
}
