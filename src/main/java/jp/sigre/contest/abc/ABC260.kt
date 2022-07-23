package jp.sigre.contest.abc

import java.io.PrintWriter
import java.util.*
import kotlin.math.cos
import kotlin.math.sin

@Suppress("unused", "PrivatePropertyName")
class ABC260 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val S = sc.next()

        for(c in S) {
            var count = 0
            for (c2 in S) {
                if (c == c2) count++
            }
            if (count==1) {
                writer.println(c)
                writer.flush()
                return
            }
        }

        writer.println("-1")
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val X = sc.nextInt()
        val Y = sc.nextInt()
        val Z = sc.nextInt()
        val az = sc.nextInts()
        val bz = sc.nextInts()

        val list = mutableListOf<Triple<Int, Int, Int>>()
        val result = mutableListOf<Int>()
        for ((i, a) in az.withIndex()) {
            val b = bz[i]
            list.add(Triple(i + 1, a, b))
        }

        val list2 = list.sortedWith(compareByDescending <Triple<Int, Int, Int>> { it.second }.thenBy { it.first }).toMutableList()

        repeat(X) {
            result.add(list2[0].first)
            list2.removeAt(0)
        }

        val list3 = list2.sortedWith(compareByDescending <Triple<Int, Int, Int>> { it.third }.thenBy { it.first }).toMutableList()

        repeat(Y) {
            result.add(list3[0].first)
            list3.removeAt(0)
        }

        val list4 =
            list3.sortedWith(compareByDescending <Triple<Int, Int, Int>> { it.third + it.second }.thenBy { it.first }).toMutableList()

        repeat(Z) {
            result.add(list4[0].first)
            list4.removeAt(0)
        }

        for (r in result.sorted()) writer.println(r)

        writer.flush()
    }

    var X = -1
    var Y = -1
    lateinit var redTmp: LongArray
    lateinit var bluTmp: LongArray

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()

        redTmp = LongArray(11) { -1 }
        bluTmp = LongArray(11) { -1 }

        X = sc.nextInt()
        Y = sc.nextInt()

        writer.println(red(N))

        writer.flush()
    }

    fun red(n: Int): Long {
        return when {
            n == 1 -> 0
            redTmp[n] != -1L -> redTmp[n]
            else -> {
                val l = red(n - 1) + blue(n) * X
                redTmp[n] = l
                l
            }
        }
    }

    fun blue(n: Int): Long {
        return when {
            n == 1 -> 1
            bluTmp[n] != -1L -> bluTmp[n]
            else -> {
                val l = red(n - 1) + blue(n - 1) * Y
                bluTmp[n] = l
                l
            }
        }
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