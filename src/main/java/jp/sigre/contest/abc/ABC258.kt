package jp.sigre.contest.abc

import java.io.PrintWriter
import java.util.*
import kotlin.math.*

@Suppress("unused", "PrivatePropertyName")
class ABC258 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val K = sc.nextInt()

        val h = K / 60
        var m = (K - (h * 60)).toString()
        if (m.length == 1) m = "0$m"

        writer.println((21+h).toString() + ":" + m)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val arr = Array(3 * N) {
            IntArray(3 * N)
        }
        for (i in 0 until N) {
            val a = sc.next().toCharArray()

            for (j in a.indices) {
                arr[i][j] = a[j].toString().toInt()
                arr[i][j + N] = a[j].toString().toInt()
                arr[i][j + N + N] = a[j].toString().toInt()
            }

            arr[i + N] = arr[i]
            arr[i + N + N] = arr[i]
        }

        var result = 0L
        var tmp = 0L

        for (i in 0 + N until N + N) {
            for (j in 0 + N until N + N) {
                // 右
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i][j + k]
                }
                result = max(result, tmp)
                tmp = 0L
                // 左
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i][j - k]
                }
                result = max(result, tmp)
                tmp = 0L
                // 上
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i - k][j]
                }
                result = max(result, tmp)
                tmp = 0L
                // 下
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i + k][j]
                }
                result = max(result, tmp)
                tmp = 0L
                // 右上
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i - k][j + k]
                }
                result = max(result, tmp)
                tmp = 0L
                // 右下
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i + k][j + k]
                }
                result = max(result, tmp)
                tmp = 0L
                // 左上
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i - k][j - k]
                }
                result = max(result, tmp)
                tmp = 0L
                // 左上
                for (k in 0 until N) {
                    tmp = tmp * 10 + arr[i + k][j - k]
                }
                result = max(result, tmp)
                tmp = 0L
            }
        }

        writer.println(result)
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val Q = sc.nextInt()
        val s = sc.next()

        var cx = 0
        repeat(Q) {
            val t = sc.nextInt()
            val x = sc.nextInt()

            if (t == 1) {
                cx += x
            } else {
                var idx = x - 1 - cx % N
                if (idx < 0) idx += N
                writer.println(s.substring(idx, idx + 1))
            }
        }

        writer.flush()
    }

    private fun d() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val X = sc.nextInt()
        var befTime = 0L
        var befCount = 0
        var result = Long.MAX_VALUE

        repeat(N) {
            val a = sc.nextLong()
            val b = sc.nextLong()

            //対象回のストーリーまで befTime に
            befTime += a

            if (X - befCount == 0) return@repeat

            result = min(result, befTime + b * (X - befCount))

            if (result < 0) {
                throw Exception()
            }

            // 事後処理 事前にクリアした回数
            befCount++

            // ゲームプレイを事前に追加
            befTime += b
        }

        writer.println(result)
        writer.flush()
    }

    // region Scanner
    private var st = StringTokenizer("")
    private val br = System.`in`.bufferedReader()

    fun next(): String {
        while (!st.hasMoreTokens()) st = StringTokenizer(br.readLine())
        return st.nextToken()
    }

    private fun nextInt() = next().toInt()
    private fun nextLong() = next().toLong()
    private fun nextDouble() = next().toDouble()

    private fun nextLine() = br.readLine()!!
    private fun nextInts() = nextLine().split(" ").map(String::toInt)
    private fun nextStrings() = nextLine().split(" ")
}