package jp.sigre.contest.abc.abc248.a;

import java.util.Scanner;

public class Main {

    static long INF = 1000000000000L;
    static long res = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s     = sc.next();

        for (int i = 0; i <= 9; i++) {
            String s1 = String.valueOf(i);

            if (!s.contains(s1)) {
                System.out.println(s1);
                return;
            }
        }
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
