package jp.sigre.contest.abc.abc247.a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =Integer.parseInt(sc.next(), 2);
        int i = n >> 1;

        System.out.println(String.format("%4s", Integer.toBinaryString(i)).replace(" ", "0"));
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
