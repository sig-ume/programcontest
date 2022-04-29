package jp.sigre.contest.typical_algorithm.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 区間スケジューリング問題・貪欲法
 */
public class Main {

    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(sc.nextInt(), sc.nextInt());
        }

        Task[] sorted = Arrays.stream(tasks).sorted(Comparator.comparingInt(o -> o.end)).toArray(Task[]::new);

        int endTime = 0;

        for (Task t : sorted) {
            if (t.start < endTime) {
                continue;
            }

            count++;
            endTime = t.end;
        }

        System.out.println(count);
    }

    private static class Task {
        int start;
        int end;

        public Task(int s, int e) {
            start = s;
            end = e;
        }
    }
}
