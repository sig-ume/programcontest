package jp.sigre.contest.template.b

import java.io.PrintWriter
import java.util.*

var N = 0
var tmp = 0
var result = 0

fun main() {
    val writer = PrintWriter(System.out, false)

    jp.sigre.contest.template.a.N = jp.sigre.contest.template.a.nextInt()
    val a = jp.sigre.contest.template.a.nextInts()
    println(a.sum())
    writer.flush()
}

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