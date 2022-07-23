package jp.sigre.contest

import java.util.*
import kotlin.math.sqrt

/**
 * よく使うであろう解法を事前に作成しておく
 */
/**
 * しゃくとり法
 *
 * @param ints 尺取するリスト
 * @return なにか
 */
@Suppress("unused", "RedundantVisibilityModifier")
public fun shakutori(ints: IntArray): Long {
    val result: Long = 0
    val deque: Deque<Int> = ArrayDeque()
    for (num in ints) {
        deque.add(num)
        var left = 0
        while (left == 0) {
            if (deque.peekLast() == null) {
                break
            }
            left = deque.pollFirst()
        }
    }
    return result
}

/**
 * DP法(ナップサック問題)
 *
 * @param n 石の種類
 * @param w 最大重量
 */
@Suppress("unused", "RedundantVisibilityModifier")
public fun dp(sc: Scanner, n: Int, w: Int) {
    val memo = Array(n + 1) { LongArray(w + 1) }
    val stones = arrayOfNulls<Stone>(n)
    for (i in 0 until n) {
        stones[i] = Stone(sc.nextInt(), sc.nextInt().toLong())
    }
    for (tN in n downTo 0) {
        for (tW in w downTo 0) {
            if (tN >= n) {
                memo[tN][tW] = 0
                continue
            }
            val stone = stones[tN]
            val valueOfIn = if (w >= tW + stone!!.weight) memo[tN + 1][tW + stone.weight] + stone.value else -1
            val valueOfNotIn = memo[tN + 1][tW]
            memo[tN][tW] = maxOf(valueOfNotIn, valueOfIn)
        }
    }
    println(memo[0][0])
}

/**
 * SPF(Smallest Prime Factor: 各数に対する最小の素因数
 * 素因数分解、素数確認
 *
 * 前処理: O(n log log n)
 * クエリ: O(log n)
 *
 * https://qiita.com/rsk0315_h4x/items/ff3b542a4468679fb409
 * https://algo-logic.info/prime-fact/
 */
@Suppress("unused", "RedundantVisibilityModifier")
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

/**
 * 素数リスト(エラトステネスの篩)
 * TODO : SPFがあれば使わないか？
 *
 * @param maxNumber 素数を求めたい最大値
 * @return 素数リスト
 */
@Suppress("unused", "RedundantVisibilityModifier")
public fun getPrimeArrayUnder(maxNumber: Int): List<Int> {
    val targetNumbers = BooleanArray(maxNumber + 1)
    Arrays.fill(targetNumbers, true)
    targetNumbers[0] = false
    targetNumbers[1] = false

    // 素数リスト
    val primeNumbers: MutableList<Int> = ArrayList()
    val sqrt = sqrt(maxNumber.toDouble()).toInt()

    // ステップ3：探索リストの先頭の値が、引数の平方根に達するまでふるい落とし操作を続ける。
    for (i in 2..sqrt) {
        // ステップ2：探索リストの先頭の数を素数とし、その倍数を探索リストから篩い落とす。
        // ※この時、既に篩い落とされた数（false）は除外する。
        if (targetNumbers[i]) {
            var j = i * i
            while (j < targetNumbers.size) {
                targetNumbers[j] = false
                j += i
            }
        }
    }

    // ステップ4：探索リストに残った値を素数リストに移して処理終了。
    for (i in 2 until targetNumbers.size) {
        if (targetNumbers[i]) {
            primeNumbers.add(i)
        }
    }
    return primeNumbers
}

// 最大公約数を求める。
@Suppress("unused", "RedundantVisibilityModifier")
public fun calcGcd(m: Long, n: Long): Long {
    var l = m
    var s = n
    require(!(l <= 0 || s <= 0)) { "Arguments must be 1 and over." }
    if (l < s) {
        val tmp = l
        l = s
        s = tmp
    }
    var remainder: Long
    while (l % s.also { remainder = it } != 0L) {
        l = s
        s = remainder
    }
    return s
}

// 最小公倍数を求める。
@Suppress("unused", "RedundantVisibilityModifier")
public fun calcLcm(m: Long, n: Long): Long {
    return m * n / calcGcd(m, n)
}

private class Stone(var weight: Int, var value: Long)

/**
 * 二分探索
 * 一般化した二分探索の例
 *myBinarySearch(0, 100) { it * it > 50 } // -> 8
 *
 * 逆からも探索可能
 * myBinarySearch(100, 0) { it * it < 50 } // -> 7
 *
 * List の拡張関数として使う例 （Array も同様）
 * val list = listOf(2, 4, 6, 8, 10)
 * list.myBinarySearch { it >= 5 } // -> 2
 *
 * 条件に合うものが存在しない場合: 配列の長さと同じ値
 */
fun myBinarySearch(begin: Int, end: Int, isOk: (key: Int) -> Boolean): Int {
    var ng = begin
    var ok = end

    while (Math.abs(ok - ng) > 1) {
        val mid = (ok + ng) / 2
        if (isOk(mid)) {
            ok = mid
        } else {
            ng = mid
        }
    }

    return ok
}

fun <T> List<T>.myBinarySearch(isOk: (T) -> Boolean): Int {
    return myBinarySearch(-1, size) { index -> isOk(get(index)) }
}

fun <T> Array<T>.myBinarySearch(isOk: (T) -> Boolean): Int {
    return myBinarySearch(-1, size) { index -> isOk(get(index)) }
}

fun lower_bound(ints: IntArray, i: Int): Int {
    return ints.toTypedArray().myBinarySearch { it >= i }
}

fun upper_bound(ints: IntArray, i: Int): Int {
    return ints.toTypedArray().myBinarySearch { it > i }
}

@Suppress("unused", "RedundantVisibilityModifier")
public fun runLength(S: String): List<Pair<Char, Int>> {
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

    return list
}

/**
 *
 * UnionFind
 */
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