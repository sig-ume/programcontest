package jp.sigre.contest.abc

import java.io.PrintWriter
import java.util.*
import kotlin.math.*

@Suppress("unused", "PrivatePropertyName")
class ABC255 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)

        N = nextInt()

        repeat(N) {
            result *= 2
        }
        writer.println(result)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)

        N = nextInt()
        val az = nextInts()
        var masu = 0
        for (a in az) {
            masu++
            masu = masu.shl(a)

            result += Integer.toBinaryString(masu.and(240)).count { c -> c == '1' } // 11110000

            masu = masu.and(15) // 1111
        }

        writer.println(result)

        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)

        writer.println(c2())
        writer.flush()
    }

    fun c2(): Int {
        var result = 0
        val h0 = nextInt()
        val h1 = nextInt()
        val h2 = nextInt()
        val w0 = nextInt()
        val w1 = nextInt()
        val w2 = nextInt()

        for (a in 1..30) {
            for (b in 1..30) {
                for (d in 1..30) {
                    for (e in 1..30) {
                        val c = h0 - (a + b)
                        val f = h1 - (d + e)
                        val g = w0 - (a + d)
                        val h = w1 - (b + e)
                        val i = w2 - (c + f)
                        if (g <= 0) continue
                        if (h <= 0) continue
                        if (i <= 0) continue
                        if (c <= 0) continue
                        if (f <= 0) continue
                        if (h2 != g + h + i) continue

                        result++
                    }
                }
            }
        }
        return result
    }

    private fun d() {

        val writer = PrintWriter(System.out, false)

        N = nextInt()

        val list = ArrayList<Pair<Int, Int>>()

        repeat(N) {
            val l = nextInt()
            val r = nextInt()
            list.add(Pair(l, r))
        }

        list.sortBy { pair -> pair.first }

        val result = ArrayList<Pair<Int, Int>>()
        var pair1 = Pair(0, 0)

        for (pair in list) {
            pair1 = if (pair1.first == 0) pair
            else {
                if (pair.first <= pair1.second) {
                    pair1.copy(second = max(pair1.second, pair.second))
                } else {
                    result.add(pair1)
                    pair
                }
            }
        }

        if (pair1.first != 0) result.add(pair1)

        for (r in result) {
            println("${r.first} ${r.second}")
        }

        writer.flush()
    }

    class PrimeFact(N: Int) {
        private var spf = IntArray(N + 1) { it }

        init {
            var i = 2
            do {
                if (spf[i] < i) continue
                var j = i * i
                while (j <= N) {
                    spf[j] = if (spf[j] == j) i else spf[j]
                    j += i
                }
            } while (++i * i <= N)
        }

        private fun factorize(n: Int): Map<Int, Int> {
            var x = n
            val res = HashMap<Int, Int>()
            while (x != 1) {
                val min = spf[x]
                res.putIfAbsent(min, 0)
                res[min] = res[min]!! + 1
                x /= min
            }

            return res
        }

        fun isPrime(n: Int): Boolean {
            return spf[n] == n
        }

        fun getDivisorCount(n: Int): Int {
            //TODO
            return n
        }

        fun getDivisors(n: Int): List<Long> {
            val map = factorize(n)
            val divs = arrayListOf<Pair<Int, Int>>()
            map.forEach { (f, s) ->
                // 通常は×2しない
                divs.add(Pair(f, s * 2))
            }

            val ret = arrayListOf<Long>()
            dfs(ret, divs, 0, 1)

            return ret
        }

        private fun dfs(ret: ArrayList<Long>, divs: List<Pair<Int, Int>>, idx: Int, ans: Long) {
            if (idx == divs.size) {
                ret.add(ans)
                return
            }
            var mul = 1L
            repeat(divs[idx].second + 1) {
                dfs(ret, divs, idx + 1, ans * mul)
                mul *= divs[idx].first
            }
        }
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