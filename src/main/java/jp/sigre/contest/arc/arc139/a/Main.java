package jp.sigre.contest.arc.arc139.a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ts = getMultipleNumbers(sc, n);

        long now = 0;
        for (int t : ts) {
            long tmp = now >> t;
            if (Long.numberOfTrailingZeros(tmp) > 0) {
                tmp++;
            } else {
                tmp += 2;
            }
            now = tmp << t;

        }

        System.out.println(now);
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
