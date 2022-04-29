package jp.sigre.contest.typical_algorithm.a;

import java.util.Scanner;

/**
 * 二分探索
 */
public class Main {

    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] as = getMultipleNumbers(sc, n);
        int left = 0;
        int right = as.length -1;

        if (as[right] < k) {
            System.out.println(-1);
            return;
        }

        while (true) {
            int c = (left + right) / 2;

            if (as[c] < k) {
                // cは対象外なので削る
                left = c + 1;
            } else if (k <= as[c]) {
                right = c;
            }

            if (left == right) {
                result = left;
                break;
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
