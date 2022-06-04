package jp.sigre.contest.abc

import java.io.PrintWriter
import java.util.*

@Suppress("unused", "PrivatePropertyName")
class ABC254 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)

        N = nextInt()

        result = N - (N /100) * 100
        if(result < 10) print(0)
        println(result)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)

        N = nextInt()
        println(1)

        var befArray = IntArray(1) { 1 }
        for (i in 1 until N) {
            val ar = IntArray(i + 1)
            for (j in 0 until i + 1) {
                ar[j] = when (j) {
                    0 ->  1
                    i ->  1
                    else -> befArray[j-1] + (if(j < befArray.size) befArray[j] else 0)
                }
            }
            println(ar.joinToString(" "))
            befArray = ar
        }
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)

        N = nextInt()
        val K = nextInt()
        val az = nextInts().toMutableList()

        for (i in 0..K) {
            val bz = IntArray(N / K + 1)
            for (j in 0..N / K) {
                if (i + j * K < N) bz[j] = az[i + j * K]
                else bz[j] = Int.MAX_VALUE
            }
            bz.sort()
            for (j in 0..N / K) {
                if (i + j * K < N) az[i + j * K] = bz[j]
            }
        }

        for (i in 0 until az.size - 1) {
            if (az[i] > az[i + 1]) {
                println("No")
                writer.flush()
                return
            }
        }

        println("Yes")
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