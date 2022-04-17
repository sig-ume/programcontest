package jp.sigre.contest.abc.abc247.e.other;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = sc.nextInt();
        int min = sc.nextInt();

        int[] nums = getMultipleNumbers(sc, n);
        List<int[]> intsList = new ArrayList<>();

        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++) {
            if (start == -1 && min <= nums[i] && nums[i] <= max) start = i;
            if (start != -1 && (nums[i] < min || max < nums[i])) end = i;
            else if (i == n - 1) end = n;

            if (start != -1 && end != -1) {
                intsList.add(Arrays.copyOfRange(nums, start, end));
                start = -1;
                end = -1;
            }
        }

        long result = 0;

        for (int[] ints : intsList) {
            result += minMax2(ints, max, min);
        }

        System.out.println(result);
    }


    private static long minMax2(int[] ints, int max, int min) {

        int minCount = 0;
        int maxCount = 0;
        long result = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < ints.length; i++) {
            int num = ints[i];
            if (num == min) minCount++;
            if (num == max) maxCount++;

            deque.add(num);
            int left;
            while (minCount * maxCount != 0) {
                result += ints.length - i;
                if (deque.peekLast() == null) {
                    break;
                }
                left = deque.pollFirst();
                if (left == min) minCount--;
                if (left == max) maxCount--;
            }
        }

        return result;
    }

    private static long minMax(int[] ints, int max, int min) {

        int minCount = 0;
        int maxCount = 0;
        long result = 0;

        int l = 0;
        int r = 0;

        for (; l < ints.length; l++) {
            for (; r < ints.length && (maxCount == 0 || minCount == 0); r++) {
                if (ints[r] == max) maxCount++;
                if (ints[r] == min) minCount++;
            }
            if (minCount * maxCount != 0) result += ints.length - r + 1;
            if (ints[l] == max) maxCount--;
            if (ints[l] == min) minCount--;
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
