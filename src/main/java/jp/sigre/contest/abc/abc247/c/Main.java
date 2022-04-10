package jp.sigre.contest.abc.abc247.c;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] memo = new String[n+1];
        for(int i = 0; i < n+1; i++) {
            //拡張for文だと値渡しらしいので気をつけようね
            memo[i] = "";
        }

        System.out.println(create(n, memo));
    }


    private static String create(int i, String[] memo) {
        if (i == 1) return "1";
        if (!memo[i].equals("")) return memo[i];
        String result = create(i - 1, memo) + " " + i + " " + create(i - 1, memo);
        memo[i] = result;
        return result;
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
