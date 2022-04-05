package jp.sigre.contest.abc.abc083.b_somesum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;

        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            if (a <= sum && sum <= b) result += i;
        }

        System.out.println(result);
    }

    private static int sum(int num) {
        int result = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            result += Integer.valueOf(String.valueOf(c));
        }

        return result;
    }
}
