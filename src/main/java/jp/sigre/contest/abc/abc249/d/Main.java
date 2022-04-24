package jp.sigre.contest.abc.abc249.d;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = getMultipleNumbers(sc, n);

        Map<Integer, Integer> c = new HashMap<>();
        int aMax = 0;
        for (int i : a) {
            c.merge(i, 1, Integer::sum);
            aMax = Math.max(aMax, i);
        }

        long result = 0;
        for (int aj = 1; aj <= aMax; aj++) {
            for (int ak = 1; ak <= aMax / aj; ak++) {
                if (aj * ak > aMax) continue;

                result += (long) c.getOrDefault(aj, 0)
                        * c.getOrDefault(ak, 0)
                        * c.getOrDefault(aj * ak, 0);
            }
        }

        System.out.println(result);
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
