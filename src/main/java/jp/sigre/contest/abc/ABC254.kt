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

    private fun d(primeFact: PrimeFact, n: Int): Long {
        var result = 0L
        for (i in n downTo 1) {
            val divs = primeFact.getDivisors(i)
            val sq: Long = i.toLong() * i
            for (value in divs) {
                if (value <= n && sq / value <= n) result++
            }
        }
        return result
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

        fun factorize(n: Int): Map<Int, Int> {
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