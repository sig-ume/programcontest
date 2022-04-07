package jp.sigre.contest.abc.abc085.c_otoshidama;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int y = sc.nextInt();

        for (int i = n; i >= 0; i--) {
            for (int j = n - i; j >= 0; j--) {
                int k = n - i - j;
                int otoshidama = i * 10000 + j * 5000 + k * 1000;
                if (otoshidama == y) {
                    System.out.println(i + " " + j + " " + k);
                    return;
                }
            }
        }

        System.out.println("-1 -1 -1");
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
