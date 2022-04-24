package jp.sigre.contest.arc.arc139.a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ts = getMultipleNumbers(sc, n);
        String s3 = Long.toBinaryString(219901226043572224L);

        long now = 0;
        int pastT = -1;
        boolean first = true;
        for (int t : ts) {
            if (first) {
                now = 1L << t;
                first = false;
            } else if (pastT > t) {
                now = now | 1L << t;
            } else if (pastT == t) {
                now = now + (1L << (t+1));
//                String s = Long.toBinaryString(now);
//                String s1 = s.substring(0, s.length() - t);
//                int last0 = s1.lastIndexOf("0");
//                if (last0 == -1) {
//                    String s2 = Long.toBinaryString(now);
//                    now = 1L << t;
//                    if (s2.length() > t) now += 1L << s2.length();
//                    continue;
//                } else now = now | 1L << (s.length() - last0 - t);
            } else {
                String s = Long.toBinaryString(now);
                now = 1L << t;
                if (s.length() > t) now += 1L << s.length();
            }

            pastT = t;
        }

        System.out.println(now);
        //System.out.println(Long.toBinaryString(now));
    }


    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
