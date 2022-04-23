package jp.sigre.contest.abc.abc249.a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int x = sc.nextInt();

        int tLength = 0;
        int tWalkCount = 0;
        int tWaitCount = 0;
        int aLength = 0;
        int aWalkCount = 0;
        int aWaitCount = 0;

        for (int i = 1; i <= x; i++) {
            if (tWalkCount < a) {
                tWalkCount++;
                tLength += b;
            } else if (tWaitCount < c) {
                tWaitCount++;
            } else {
                tWaitCount = 0;
                tWalkCount = 1;
                tLength += b;
            }
            if (aWalkCount < d) {
                aWalkCount++;
                aLength += e;
            } else if (aWaitCount < f) {
                aWaitCount++;
            } else {
                aWaitCount = 0;
                aWalkCount = 1;
                aLength += e;
            }
        }

        String result = "";
        if (aLength > tLength) System.out.println("Aoki");
        if (aLength < tLength) System.out.println("Takahashi");
        if (aLength == tLength) System.out.println("Draw");

    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
