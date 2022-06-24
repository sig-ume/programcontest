package jp.sigre.contest.template.b

import java.io.PrintWriter
import java.util.*

fun main() {
    val writer = PrintWriter(System.out, false)
    val sc = Scanner();
    val N = sc.nextInt()
    var result = 0

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