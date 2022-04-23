package jp.sigre.contest.abc.abc249.b;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        char[] chars = n.toCharArray();
        boolean containBig = false;
        boolean containSma = false;
        for (int i = 0; i < chars.length; i++) {
            if (!containBig) {
                if (Character.isUpperCase(chars[i])) {
                    containBig = true;
                }
            }
            if (!containSma) {
                if (Character.isLowerCase(chars[i])) {
                    containSma = true;
                }
            }
            for (int j = 0; j < chars.length; j++) {
                if (i == j) continue;
                if (chars[i] == chars[j]) {
                    System.out.println("No");
                    return;
                }
            }
        }

        if (containBig && containSma)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
