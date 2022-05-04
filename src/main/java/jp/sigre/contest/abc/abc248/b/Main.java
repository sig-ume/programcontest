package jp.sigre.contest.abc.abc248.b;

import java.util.Scanner;

public class Main {

    static long INF = 1000000000000L;
    static long res = 0;
    static long a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();

        if (b <= a ) {

            System.out.println(0);
            return;
        }

        for (long i = 1; i < 100000; i++) {
            a = a * k;
            if (b <= a ) {
                System.out.println(i);
                return;
            }
        }
    }
}