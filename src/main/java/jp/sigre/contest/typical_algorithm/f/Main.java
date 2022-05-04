package jp.sigre.contest.typical_algorithm.f;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小全域木(UnionFind、クラスカル法)
 */
public class Main {

    static long res = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        edges = Arrays.stream(edges).sorted().toArray(Edge[]::new);

        UnionFind uf = new UnionFind(n);

        for (Edge e: edges             ) {
            if (    uf.isSameTree(e.a, e.b)) continue;
            uf.unite(e.a, e.b);
            res += e.cost;
        }

        System.out.println(res);
    }

    private static class UnionFind {
        int[] par;
        int[] sizes;
        int n;

        UnionFind(int n) {
            this.n = n;
            par = new int[n];
            sizes = new int[n];

            setup();
        }

        public int find(int x) {
            if (x == par[x]) return x;
            return par[x] = find(par[x]);
        }

        public void unite(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) return;

            if (sizes[a] < sizes[b]) {
                int tmp = b;
                b = a;
                a = tmp;
            }

            par[b] = a;
            sizes[a] += sizes[b];
        }

        public boolean isSameTree(int a, int b) {
            return find(a) == find(b);
        }

        public int size(int a) {
            return sizes[find(a)];
        }

        private void setup() {
            for (int i = 0; i < n; i++) {
                par[i] = i;
                sizes[i] = 1;
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
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
