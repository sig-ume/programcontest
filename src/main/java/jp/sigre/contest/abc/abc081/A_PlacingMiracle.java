package jp.sigre.contest.abc.abc081;

import java.util.Scanner;

public class A_PlacingMiracle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(placingMiracle(input));
    }

    public static int placingMiracle(String str) {
        return str.replace("0", "").length();
    }
}
