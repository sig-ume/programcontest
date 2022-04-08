package jp.sigre.contest.abc.abc243;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class B_HitAndBlow {

    public static void main(String[] args) {
        //int[] ints = hitAndBlow(Arrays.asList(new Integer[]{4 ,8, 1, 7, 9, 5, 6}), Arrays.asList(new Integer[]{3, 5, 1, 7, 8, 2, 6}));

        Scanner sc = new Scanner(System.in);
        int paramCount = sc.nextInt();
        List<Integer> listA = getParams(sc, paramCount);
        List<Integer> listB = getParams(sc, paramCount);
        int[] ints = hitAndBlow(listA, listB);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    private static List<Integer> getParams(Scanner sc, int count) {

        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listA.add(sc.nextInt());
        }

        return listA;
    }

    private static int[] hitAndBlow(List<Integer> listA, List<Integer> listB) {
        int hitCount = 0;
        int blowCount = 0;

        for (int indexA = 0; indexA < listA.size(); indexA++) {
            for (int indexB = 0; indexB < listB.size(); indexB++) {
                if (listA.get(indexA) == listB.get(indexB)) {
                    if (indexA == indexB) hitCount++;
                    else blowCount++;
                    break;
                }
            }
        }

        return new int[]{hitCount, blowCount};
    }
}
