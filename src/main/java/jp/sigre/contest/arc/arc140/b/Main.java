package jp.sigre.contest.arc.arc140.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static long res = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        String s = sc.next();

        boolean b = true;
        while (true) {
            if (b) {
                String s1 = s.replaceFirst("AARCC", "ARC");

                if (s1.equals(s)) {
                    s1 = s.replaceFirst("ARC", "R");
                    if(s1.equals(s)) break;
                }

                s = s1;
                res++;
                b = false;
            } else {
                String s1 = s.replace("AARCC", "w");
                String s2 = s1.replaceFirst("ARC", "AC");

                if (s2.equals(s1)) {
                    s2 = s2.replaceFirst("w", "AACC").replace("w", "AARCC");
                }

                if(s2.equals(s)) break;

                s = s2.replace("w", "AARCC");
                res++;
                b = true;
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