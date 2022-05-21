package jp.sigre.contest.abc.abc252.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    static long res = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] tss = new int[10][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();

            for (int j = 0; j <= 9; j++) {
                int point = s.lastIndexOf(String.valueOf(j));
                tss[j][i] = point;
            }
        }

        for (int[] ts : tss) {
            List<Integer> tList = new ArrayList<>();

            for (int t : ts) {
                tList.add(t);
            }
            tList.sort(Comparator.naturalOrder());
            int bef = -1;
            for (int i = 0; i < tList.size(); i++) {
                int t = tList.get(i);
                if (bef == t) {
                    tList.add(t + 10);
                }
                bef = t;
            }

            res = res == 0 ? tList.get(tList.size() - 1) : Math.min(res, tList.get(tList.size() - 1));
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