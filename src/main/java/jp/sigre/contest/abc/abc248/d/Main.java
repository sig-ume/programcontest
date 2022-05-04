package jp.sigre.contest.abc.abc248.d;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static long INF = 1000000000000L;
    static long res = 0;
    static int n;
    private static long[] bp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] as = getMultipleNumbers(sc, n);

        // RとX
        bp = new long[n + 1];

        int q = sc.nextInt();

        Qu[] qs = new Qu[q];
        for (int i = 0; i < q; i++) {
            qs[i] = new Qu(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(qs);

        int bef = 0;
        for (Qu qu : qs) {
            if (bef != qu.x) {
// bp更新
                bp = new long[n + 1];
                for (int r = 1; r <= n; r++) {
                    bp[r] = bp[r - 1];
                    int ar = as[r];
                    if (ar == qu.x) {
                        bp[r]++;
                    }
                }
                bef = qu.x;
            }
            qu.c = bp[qu.r] - bp[qu.l - 1];
        }

        Arrays.sort(qs, Comparator.comparingInt(o -> o.i));

        for (Qu qu : qs) {
            System.out.println(qu.c);
        }
    }

    private static class Qu implements Comparable<Qu> {
        int i;
        int l;
        int r;
        int x;
        long c;

        public Qu(int i, int l, int r, int x) {
            this.i = i;
            this.l = l;
            this.r = r;
            this.x = x;
        }

        @Override
        public int compareTo(Qu o) {
            return Integer.compare(x, o.x);
        }
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count + 1];
        nums[0] = 0;
        for (int i = 1; i <= count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}