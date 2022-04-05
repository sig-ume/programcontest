package jp.sigre.contest.abc.abc088.b_cardgame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Arrays.sort(get..., Comparator.reverseOrder())でよかったっぽい
        Integer[] nums = Arrays.stream(getMultipleNumbers(sc, n))
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        int resA = 0;
        int resB = 0;
        boolean bool = true;
        for (int num : nums) {
            if (bool) resA += num;
            else resB += num;

            bool = !bool;
        }

        System.out.println(resA - resB);
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
