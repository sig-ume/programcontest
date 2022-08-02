package jp.sigre.contest.abc

import jp.sigre.contest.Scanner
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

@Suppress("unused", "PrivatePropertyName")
class ABC257 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val X = sc.nextInt()

        var o = X / N
        if (X % N != 0) o++
        println((96 + o).toChar().toUpperCase())

        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner();
        val N = sc.nextInt()
        sc.nextInt()
        sc.nextInt()
        val az = sc.nextInts().toMutableList()
        val ls = sc.nextInts()

        for (l in ls) {
            val state = az[l - 1]
            if (state == N) continue
            if (az.all { a -> state + 1 != a }) az[l - 1]++
        }

        writer.println(az.joinToString(" "))
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner();
        sc.nextInt()
        val S = sc.next()
        val WS = sc.nextInts()
        val list = mutableListOf<Pair<Int, Int>>()

        var result = 0
        val cs = S.toCharArray()
        for (i in S.indices) {
            val flag = cs[i].toString().toInt()
            if (flag == 1) {
                result++
            }
            list.add(Pair(WS[i], flag))
        }

        val list2 = list.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

        var tmp = result
        for (p in list2) {
            if (p.second == 1) tmp--
            else tmp++
            result = max(tmp, result)
        }
        writer.println(result)
        writer.flush()
    }

    private fun d() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()

        val js = arrayListOf<Triple<Long, Long, Long>>()
        val dp = Array(N) { LongArray(N) }

        for (i in 0 until N) {
            val x = sc.nextLong()
            val y = sc.nextLong()
            val p = sc.nextLong()
            js.add(Triple(x, y, p))
        }

        for (i in 0 until N) {
            for (j in 0 until N) {
                val ji = js[i]
                val jj = js[j]
                dp[i][j] = if (i == j) 0
                else {
//                val d = (abs(ji.first - jj.first) + abs(ji.second - jj.second)).toDouble()
//                ceil(
//                    d / ji.third
//                ).toLong()
                    (abs(ji.first - jj.first) + abs(ji.second - jj.second) + ji.third - 1) / ji.third
                }
            }
        }

        for (k in 0 until N) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    dp[i][j] = min(dp[i][j], max(dp[i][k], dp[k][j]))
                }
            }
        }

        var result = Long.MAX_VALUE
        for (i in 0 until N) {
            var tmp = Long.MIN_VALUE
            for (j in 0 until N) {
                tmp = max(tmp, dp[i][j])
            }
            result = min(result, tmp)
        }

        writer.println(result)
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