package jp.sigre.contest.coderbyte.monoxer.d

import java.io.PrintWriter
import java.util.*

fun main() {
    val writer = PrintWriter(System.out, false)
    val sc = Scanner()
    val N = sc.nextInt()
    val M = sc.nextInt()
    val pairs = Array<Pair<Int, Int>>(M) { Pair(0, 0) }
    var result = 0

    for (y in 0 until M) {
        val nextInt = sc.nextInts()
        pairs[y] = Pair(nextInt[0],nextInt[1])
    }

    for(y in 0 until M) {
        val unionFind = UnionFind(N)
        for (x in 0 until M) {
            if (x == y) continue
            val pair = pairs[x]
            unionFind.unite(pair.first, pair.second)
        }

        for (x in 1 .. N) {
            if (unionFind.size(x) != N) {
                result += 1
                break
            }
        }
    }

    writer.println(result)
    writer.flush()
}

private class UnionFind(var n: Int) {
    var par: IntArray = IntArray(n + 1)
    var sizes: IntArray = IntArray(n + 1)
    fun find(x: Int): Int {
        return if (x == par[x]) x else find(par[x]).also { par[x] = it }
    }

    fun unite(ad: Int, bd: Int) {
        var a = find(ad)
        var b = find(bd)
        if (a == b) return
        if (sizes[a] < sizes[b]) {
            val tmp = b
            b = a
            a = tmp
        }
        par[b] = a
        sizes[a] += sizes[b]
    }

    fun isSameTree(a: Int, b: Int): Boolean {
        return find(a) == find(b)
    }

    fun size(a: Int): Int {
        return sizes[find(a)]
    }

    private fun setup() {
        for (i in 0..n) {
            par[i] = i
            sizes[i] = 1
        }
    }

    init {
        setup()
    }
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