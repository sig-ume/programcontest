package jp.sigre.contest.abc.abc249.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        String[] strs = new String[n];
        while (count < n) {
            strs[count] = sc.next();
            count++;
        }

        int result = 0;
        // 1の左シフトn回 == 2^n
        for (int i = 0; i < 1 << n; i++) {

            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 0) continue;
                String str = strs[j];

                for (Character c : str.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }

            int tmpRes = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == k) tmpRes++;
            }
            result = Math.max(result, tmpRes);
        }

        System.out.println(result);
    }

}
