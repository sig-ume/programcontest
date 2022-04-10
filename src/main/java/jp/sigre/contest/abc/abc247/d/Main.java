package jp.sigre.contest.abc.abc247.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        List<QueueBlock> blocks = new ArrayList<>();
        for (int i = 1; i <= q; i++) {
            int queueHead = sc.nextInt();
            if (queueHead == 1) {
                QueueBlock queueBlock = new QueueBlock(sc.nextInt(), sc.nextInt());
                blocks.add(queueBlock);
            } else {
                int count = sc.nextInt();

                long result = 0;
                while (count > 0) {
                    QueueBlock queueBlock = blocks.get(0);
                    if (queueBlock.count > count) {
                        result += (long) queueBlock.num * count;
                        queueBlock.count -= count;
                        count = 0;
                    } else {
                        result += (long) queueBlock.count * queueBlock.num;
                        count -= queueBlock.count;
                        blocks.remove(0);
                    }
                }
                System.out.println(result);
            }
        }
    }

    private static class QueueBlock {
        int num;
        int count;

        QueueBlock(int n, int c) {
            num = n;
            count = c;
        }
    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
