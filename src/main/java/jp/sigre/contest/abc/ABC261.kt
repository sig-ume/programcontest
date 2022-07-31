package jp.sigre.contest.abc

import java.io.PrintWriter
import java.util.*

@Suppress("unused", "PrivatePropertyName")
class ABC261 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val L1 = sc.nextInt()
        val R1 = sc.nextInt()
        val L2 = sc.nextInt()
        val R2 = sc.nextInt()
        val result = when {
            (L1 <= L2 && R2 <= R1) -> {
                R2 - L2
            }
            (L2 <= L1 && R1 <= R2) -> {
                R1 - L1
            }
            R1 <= L2 -> {
                0
            }
            R2 <= L1 -> {
                0
            }
            L1 <= L2 && R1 <= R2 -> {
                R1 - L2
            }
            L2 <= L1 && R2 <= R1 -> {
                R2 - L1
            }
            else -> 0
        }

        writer.println(result)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val arr1 = Array(N) {
            arrayOfNulls<String>(N)
        }

        for (i in 0 until N) {
            val line = sc.next()
            for (j in 0 until N) {
                arr1[i][j] = line[j].toString()
            }
        }

        for (i in 0 until N) {
            for (j in 0 until N) {
                if (i == j && arr1[i][j] != "-") {
                    println("incorrect")
                    return
                } else if (arr1[i][j] == "W" && arr1[j][i] != "L") {
                    println("incorrect")
                    return
                } else if (arr1[i][j] == "L" && arr1[j][i] != "W") {
                    println("incorrect")
                    return
                } else if (arr1[i][j] == "D" && arr1[j][i] != "D") {
                    println("incorrect")
                    return
                }
            }
        }

        writer.println("correct")
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()

        val memo = mutableMapOf<String, Int>()

        repeat(N) {
            val S = sc.next()
            if (memo.containsKey(S)) {
                writer.println("${S}(${memo[S]})")
                memo[S] = memo[S]?.plus(1)!!
            } else {
                writer.println(S)
                memo[S] = 1
            }
        }

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