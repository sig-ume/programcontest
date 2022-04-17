package jp.sigre.contest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
    }

    /**
     * しゃくとり法
     * @param ints
     * @return
     */
    private static long shakutori(int[] ints) {
        long result = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < ints.length; i++) {
            int num = ints[i];

            deque.add(num);
            int left = 0;
            while (left == 0) {

                if (deque.peekLast() == null) {
                    break;
                }
                left = deque.pollFirst();
            }
        }

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
