package jp.sigre.contest.abc.abc247.e;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] nums = getMultipleNumbers(sc, n);

        int iMax = -1;
        int iMin = -1;
        int d = -1;

        long result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) iMax = i;
            if (nums[i] == y) iMin = i;
            if (nums[i] < y || x < nums[i]) d = i;

            int min = Math.min(iMax, iMin);
            if (d < min) {
                result += min - d;
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
