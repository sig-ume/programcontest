package jp.sigre.contest.abc.abc249.d;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = getMultipleNumbers(sc, n);
        Map<Trips, Boolean> memo = new HashMap<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (check(nums, i, j, k, memo)) {
                       result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
    
    private static boolean check(int[]nums , int i, int j, int k, Map<Trips, Boolean> memo) {
        int ai = nums[i];
        int aj = nums[j];
        int ak = nums[k];

        Trips trips = new Trips(ai, aj, ak);

        if (memo.containsKey(trips)) return memo.get(trips);
        if (ai%aj != 0) {
            memo.put(trips, false);
            return false;
        }
        memo.put(trips, ai / aj == ak);
        return ai / aj == ak;
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }

    private static class Trips {
        int i;
        int j;
        int k;

        public Trips(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trips trips = (Trips) o;
            return i == trips.i && j == trips.j && k == trips.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }
    }
}
