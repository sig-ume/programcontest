package jp.sigre.contest.abc.abc087.b_coins;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y500 = sc.nextInt();
        int y100 = sc.nextInt();
        int y050 = sc.nextInt();

        int yMax = sc.nextInt();

        int result = 0;

        for (int r500 = 0; r500 <= y500; r500++) {
            for (int r100 = 0; r100 <= y100; r100++) {
                for (int r050 = 0; r050 <= y050; r050++) {
                    if (500 * r500 + 100 * r100 + 50 * r050 != yMax) continue;

                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
