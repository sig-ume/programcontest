package jp.sigre.contest.abc.abc253.d;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {

    static long N;
    static FastScanner sc;

    public static void main(String[] args) {
        sc = new FastScanner();

        N = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();

        long sum = (N * (N + 1)) / 2;

        long aCount = N / A;
        long aSum = (aCount + 1) * aCount / 2 * A;

        long bCount = N / B;
        long bSum = (bCount + 1) * bCount / 2 * B;

        long lcm = calcLcm(A, B);
        long abCount = N / lcm;
        long abSum = (abCount + 1) * abCount / 2 * lcm;

        System.out.println(sum - aSum - bSum + abSum);
    }

    // 最大公約数を求める。
    static long calcGcd(long m, long n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("Arguments must be 1 and over.");
        }
        if (m < n) {
            long tmp = m;
            m = n;
            n = tmp;
        }
        long remainder;
        while ((remainder = m % n) != 0) {
            m = n;
            n = remainder;
        }
        return n;
    }

    // 最小公倍数を求める。
    static long calcLcm(long m, long n) {
        return m * n / calcGcd(m, n);
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