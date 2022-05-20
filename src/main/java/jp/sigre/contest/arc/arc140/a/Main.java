package jp.sigre.contest.arc.arc140.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;

public class Main {

    static long INF = 1000000000000L;
    static long res = 0;
    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idxList.add(i);
        }
        String str = sc.next();
        String str2 = str;
        for (int i = 0; i < n; i++) {
            str2 = str2.substring(1) + str2.toCharArray()[0];
            idxList.add(idxList.get(0));
            idxList.remove(0);

            Function<String, Map<Integer, Integer>> d = (s2) -> {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (str.charAt(j) != s2.charAt(j)) {
                        map.put(j, idxList.get(j));
                    }
                }
                return map;
            };
            Map<Integer, Integer> diff = d.apply(str2);
            diff.entrySet()

            int div = i % 2 == 0 ? 1 : 2;
            if (distance / div <= k) {
                res = i + 1;
                break;
            }
        }

        System.out.println(res);
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
