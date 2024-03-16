package jp.sigre.contest.abc.abc074.b

import java.io.PrintWriter
import java.util.*
import kotlin.math.abs

fun main() {
    val writer = PrintWriter(System.out, false)
    val sc = Scanner()
    val N = sc.nextInt()
    val K = sc.nextInt()
    val ints = sc.nextInts()
    var result = 0

    for (x in ints) {
        val moveB = abs(K - x)
        val moveA = x

        result += Math.min(moveA, moveB)
    }

    result *= 2

    writer.println(result)
    writer.flush()
}

private class Scanner {
    // region Scanner
    private var st = StringTokenizer("")
    private val br = System.`in`.bufferedReader()

    fun next(): String {
        while (!st.hasMoreTokens()) st = StringTokenizer(br.readLine())
        return st.nextToken()
    }

    fun nextInt() = next().toInt()
    fun nextLong() = next().toLong()
    fun nextDouble() = next().toDouble()

    fun nextLine() = br.readLine()!!
    fun nextInts() = nextLine().split(" ").map(String::toInt)
    fun nextStrings() = nextLine().split(" ")
}