package jp.sigre.contest.abc.abc253.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static int H;
    static int tmp;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        H = sc.nextInt();
        //int W = sc.nextInt();

        boolean c = false;
        int x = 0;
        int y = 0;
        for (int h = 1; h <= H; h++) {
            String s = sc.next();
            int idx = s.indexOf("o");
            int idx2 = s.lastIndexOf("o");
            if (idx != idx2) {
                tmp = Math.abs(idx - idx2);
                break;
            }
            if (idx != -1) {
                if (c) {
                    tmp = Math.abs(x - idx) + Math.abs(y - h);
                    break;
                }
                x = idx;
                y = h;
                c = true;
            }
        }

        System.out.println(tmp);
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