package jp.sigre.contest.abc.abc243;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class A_Shampoo {

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(shampoo(new int[]{a, b, c, d}));
    }

    public static int[] inputToInts(String str) {
        String[] args = str.split(" ");
        int[] ints = Stream.of(args).mapToInt(Integer::parseInt).toArray();

        return ints;
    }

    public static String shampoo(int[] ints) {
        int shampooSize = ints[0];
        int[] useSizeInts = Arrays.copyOfRange(ints, 1, ints.length);
        int useCount;
        for (useCount = 0; shampooSize >= 0; useCount++) {
            shampooSize -= useSizeInts[(useCount) % 3];

        }

        String result = "";
        switch (useCount % 3) {
            case 1 : result = "F"; break;
            case 2 : result = "M"; break;
            default: result = "T";
        }

        return result;
    }
}
