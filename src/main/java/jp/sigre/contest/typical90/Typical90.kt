package jp.sigre.contest.typical90

import jp.sigre.contest.Scanner
import jp.sigre.contest.myBinarySearch
import java.io.PrintWriter
import kotlin.math.max
import kotlin.math.min

@Suppress("unused", "PrivatePropertyName")
class Typical90 {
    var N = 0
    var L = 0
    var K = 0
    var az = List(1) { 0 }

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        N = sc.nextInt()
        L = sc.nextInt()
        K = sc.nextInt()

        az = sc.nextInts()

        val MAX = L / (K + 1)
        writer.println(myBinarySearch(MAX + 1, 1) { culc(it) })
        writer.flush()
    }

    fun culc(result: Int): Boolean {
        var now: Int
        var bef = 0
        var k = 0

        for (n in 0 until N) {
            now = az[n] - bef

            if (now >= result) {
                bef = az[n]
                k++
                if (k == K) break
            }
        }

        if (L - bef >= result && k == K) {
            return true
        }
        return false
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
}