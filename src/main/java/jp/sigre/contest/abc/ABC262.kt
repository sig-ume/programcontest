package jp.sigre.contest.abc

import java.io.PrintWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

@Suppress("unused", "PrivatePropertyName")
class ABC262 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()

        val Y = sc.nextInt()

        val result = when (Y % 4) {
            3 -> Y + 3
            0 -> Y + 2
            1 -> Y + 1
            else -> Y
        }

        writer.println(result)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()

        val N = sc.nextInt()
        val M = sc.nextInt()
        val arr1 = Array(N) {
            BooleanArray(M) { false }
        }

        for (i in 0 until M) {
            val U = sc.nextInt() - 1
            val V = sc.nextInt() - 1
            arr1[U][V] = true
        }

        var result = 0
        for (i in 0 until N) {
            for (j in i + 1 until N) {
                for (k in j + 1 until N) {
                    if (arr1[i][j] && arr1[j][k] && arr1[i][k]) result++
                }
            }
        }

        writer.println(result)
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val az = IntArray(N + 1)
        az[0] = 0

        for (i in 1..N) {
            az[i] = sc.nextInt()
        }

        var result = 0L
        var same = 0L
        for (i in 1..N) {
            if (az[i] == i) {
                same++
            } else {
                if (max(az[i], az[az[i]]) == az[i] && min(az[i], az[az[i]]) == i) result++
            }
        }

        result += (same * (same - 1) / 2)

        writer.println(result)
        writer.flush()
    }

    private fun d() {

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