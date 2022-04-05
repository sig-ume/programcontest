package jp.sigre.contest.abc.abc081;

import java.util.Scanner;

public class B_ShiftOnly {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] nums = getMultipleNumbers(sc, count);

        int minZeroCount = Integer.MAX_VALUE;
        for (int num : nums) {
            int zeroCount = Integer.numberOfTrailingZeros(num);
            if (minZeroCount > zeroCount) minZeroCount = zeroCount;
        }

        System.out.println(minZeroCount);
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
