package jp.sigre.contest.abc.abc248.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        n = sc.nextInt();
        int[] as = getMultipleNumbers(sc, n);

        int q = sc.nextInt();

        Map<Integer, List<List<Integer>>> qMap = new HashMap<>(n + 1, 2);

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            addXAndI(qMap, i, l - 1, x, 0);
            addXAndI(qMap, i, r, x, 1);
        }

        long[] res = new long[q];
        long[] cnt = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int ai = as[i];
            cnt[ai]++;

            if (!qMap.containsKey(i)) continue;

            List<List<Integer>> queues = qMap.get(i);
            for (List<Integer> qu : queues) {
                Integer x = qu.get(0);
                Integer idx = qu.get(1);
                Integer isR = qu.get(2);
                if (isR == 1) {
                    res[idx] += cnt[x];
                } else {
                    res[idx] -= cnt[x];
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (long r : res) {
            out.println(r);
        }
        out.flush();
    }

    private static void addXAndI(Map<Integer, List<List<Integer>>> qMap, int i, int lr, int x, int isR) {
        List<List<Integer>> orDefault = qMap.getOrDefault(lr, new ArrayList<>());
        orDefault.add(Arrays.asList(x, i, isR));
        qMap.put(lr, orDefault);
    }

    private static int[] getMultipleNumbers(FastScanner sc, int count) {
        int[] nums = new int[count + 1];
        nums[0] = 0;
        for (int i = 1; i <= count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }

    @SuppressWarnings("unused")
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int bufLen = 0;

        private boolean hasNextByte() {
            if (ptr < bufLen) {
                return true;
            } else {
                ptr = 0;
                try {
                    bufLen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bufLen > 0;
            }
        }

        private int readByte() {
            if (hasNextByte()) return buffer[ptr++];
            else return -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        @SuppressWarnings("BooleanMethodIsAlwaysInverted")
        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}