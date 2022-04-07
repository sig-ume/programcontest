package jp.sigre.education_dp_contest.b_flog2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = getMultipleNumbers(sc, n);

        List<Step> steps = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> steps.add(new Step(num, Integer.MAX_VALUE)));

        Step step0 = steps.get(0);
        step0.cost = 0;
        Step step1 = steps.get(1);
        step1.cost = Math.abs(step1.height - step0.height);

        for (int i = 2; i < steps.size(); i++) {
            calcCost(steps, i, k);
        }

        System.out.println(steps.get(steps.size() - 1).cost);
    }

    private static void calcCost(List<Step> steps, int index, int limit) {
        List<Step> subSteps = steps.subList(Math.max(index - limit, 0), index + 1);
        Step now = subSteps.get(subSteps.size() - 1);
        for (int i = 0; i < subSteps.size() - 1; i++) {
            now.cost = Math.min(getCostInTwoPoint(now, subSteps.get(i)), now.cost);
        }
    }

    private static int getCostInTwoPoint(Step now, Step bef) {
        return Math.abs(now.height - bef.height) + bef.cost;
    }

    private static class Step {
        int height;
        int cost;

        Step(int height, int cost) {
            this.height = height;
            this.cost = cost;
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
