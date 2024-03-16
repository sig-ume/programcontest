package jp.sigre.contest.abc.abc074.c

import java.io.PrintWriter
import java.util.*

fun main() {
    val writer = PrintWriter(System.out, false)
    val sc = Scanner()
    val A = sc.nextInt()
    val B = sc.nextInt()
    val C = sc.nextInt()
    val D = sc.nextInt()
    val E = sc.nextInt()
    val F = sc.nextInt()
    var resultNode = 0.0
    var resultWater = 0
    var resultSugar = 0

    // x: 水の量、y：砂糖の量
    for (x in 0..3000) {
        for (y in 0..3000) {
            if (x + y > F) continue // ビーカー限界チェック
            if (x * E < y * 100) continue //溶ける量チェック
            val node = calcNode(x, y)
            if (checkWater(x, A, B) && checkSugar(y, C, D) && node > resultNode) {
                resultNode = node
                resultWater = x
                resultSugar = y
            }
        }
    }

    val sugarWaterAmount = resultWater + resultSugar
    writer.println("$sugarWaterAmount $resultSugar")
    writer.flush()
}

fun calcNode(water: Int, sugar: Int) :Double{
    return (100 * sugar).toDouble() / (water + sugar)
}

fun checkWater(water: Int, A: Int, B: Int): Boolean {
    val maxCount = water / (A * 100)
    for (a in 0..maxCount) {
        for (b in 0..maxCount) {
            if (A * 100 * a + B * 100 * b == water) return true
        }
    }

    return false
}

fun checkSugar(sugar: Int, C: Int, D: Int): Boolean {
    val maxCount = sugar / C
    for (a in 0..maxCount) {
        for (b in 0..maxCount) {
            if (C * a + D * b == sugar) return true
        }
    }

    return false
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