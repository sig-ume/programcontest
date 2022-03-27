package jp.sigre.contest.abc.abc086;

import java.util.Scanner;

public class A_Product {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(evenOdd(a, b));
    }

    private static String evenOdd(int a, int b) {
        String result = "";
        if ((a * b) % 2 == 0) {
            return "Even";
        }

        return "Odd";
    }
}
