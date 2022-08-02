package jp.sigre.contest.abc

import jp.sigre.contest.Scanner
import java.io.PrintWriter
import java.util.*
import kotlin.math.cos
import kotlin.math.sin

@Suppress("unused", "PrivatePropertyName")
class ABC259 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val M = sc.nextInt()
        val X = sc.nextInt()
        val T = sc.nextInt()
        val D = sc.nextInt()

        val start = T - D * X

        var result = if (M < X) start + M * D
        else start + X * D

        writer.println(result)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner();
        val A = sc.nextDouble()
        val B = sc.nextDouble()
        val D = Math.toRadians(sc.nextDouble())

        val afterA = A * cos(D) - B * sin(D)
        val afterB = A * sin(D) + B * cos(D)

        writer.println("$afterA $afterB")
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner();
        var S = sc.next()
        var T = sc.next()

        val list = mutableListOf<Pair<Char, Int>>()

        var idx = 0
        while (idx < S.length) {
            val c = S[idx]
            var cnt = 0
            for (i in idx until S.length) {
                val c2 = S[i]
                if (c == c2) cnt++
                else break
            }
            list.add(Pair(c, cnt))
            idx += cnt
        }

        val list2 = mutableListOf<Pair<Char, Int>>()
        idx = 0
        while (idx < T.length) {
            val c = T[idx]
            var cnt = 0
            for (i in idx until T.length) {
                val c2 = T[i]
                if (c == c2) cnt++
                else break
            }
            list2.add(Pair(c, cnt))
            idx += cnt
        }

        if (list.size != list2.size) {
            println("No")
            return
        }

        for (i in list.indices) {
            val p1 = list[i]
            val c1 = p1.first
            val s1 = p1.second

            val p2 = list2[i]
            val c2 = p2.first
            val s2 = p2.second

            if (!(c1 == c2 && (s1 == s2 || (s1 in 2 until s2)))) {
                println("No")
                return
            }
        }

        writer.println("Yes")
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