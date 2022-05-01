package jp.sigre.contest.typical_algorithm.d;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 単一始点最短経路(ダイクストラ)
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        City[] cities = new City[n];

        for (int i = 0; i < n; i++) {
            cities[i] = new City(i, Long.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            int v0 = sc.nextInt();
            int v1 = sc.nextInt();
            long c = sc.nextInt();

            cities[v0].map.put(v1, c);
        }
        cities[0].cost = 0;

        PriorityQueue<City> queue = new PriorityQueue<>();

        queue.add(cities[0]);
        while (queue.size() > 0) {
            City now = queue.poll();
            if (now.confirmed) continue;

            long cost = now.cost;
            now.confirmed = true;
            now.map.forEach((key, value) -> {
                City dest = cities[key];
                // このIFがないと同じdestを複数Queueに入れてしまう
                if (dest.cost > cost + value) {
                    dest.cost = cost + value;
                    queue.add(dest);
                }
            });
        }

        System.out.println(cities[n - 1].cost);
    }

    private static class City implements Comparable<City> {
        int name;
        long cost;
        boolean confirmed = false;

        Map<Integer, Long> map = new HashMap<>();

        public City(int name, Long cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return Long.compare(cost, o.cost);
        }
    }
}
