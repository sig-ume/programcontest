package jp.sigre.contest.abc

import jp.sigre.contest.Scanner
import java.io.PrintWriter

@Suppress("unused", "PrivatePropertyName")
class ABC265 {

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val H = sc.nextInt()
        val W = sc.nextInt()
        val arr1 = Array(H) {
            sc.nextLine().toCharArray()
        }

        val viewed = Array(H + 1) {
            BooleanArray(W + 1) { false }
        }

        var nowX = 0
        var nowY = 0

        loop@ while (true) {

            if (viewed[nowY][nowX]) {
                writer.println(-1)
                writer.flush()
                return
            }
            viewed[nowY][nowX] = true
            when (arr1[nowY][nowX]) {
                'U' -> if (nowY != 0) nowY--
                else break@loop
                'D' -> if (nowY != H - 1) nowY++
                else break@loop
                'L' -> if (nowX != 0) nowX--
                else break@loop
                'R' -> if (nowX != W - 1) nowX++
                else break@loop
                else -> throw IllegalArgumentException()
            }
        }

        writer.println("${nowY + 1} ${nowX + 1}")
        writer.flush()
    }

    private fun d() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val P = sc.nextLong()
        val Q = sc.nextLong()
        val R = sc.nextLong()

        var sum = 0L
        val sums = listOf(0L) + MutableList(N) {
            sum += sc.nextLong()
            sum
        }

        val exists = sums.any {
            sums.binarySearch(it + P) >= 0
                    && sums.binarySearch(it + P + Q) >= 0
                    && sums.binarySearch(it + P + Q + R) >= 0
        }

        writer.println(if (exists) "Yes" else "No")
        writer.flush()
    }

}