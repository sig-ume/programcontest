package jp.sigre.contest.abc.abc049.c_daydream;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        while (n.length() > 0) {
            if (n.endsWith("dream") || n.endsWith("erase")) {
                n = n.substring(0, n.length() - 5);
                continue;
            }
            if (n.endsWith("eraser")) {
                n = n.substring(0, n.length() - 6);
                continue;
            }
            if (n.endsWith("dreamer")) {
                n = n.substring(0, n.length() - 7);
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
