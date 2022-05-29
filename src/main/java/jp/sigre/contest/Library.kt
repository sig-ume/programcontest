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
 * 素数リスト(エラトステネスの篩)
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

/**
 * @param xs  Integer配列
 * @param key 探索する値
 * @return 「指定した値以上の要素」が初めて出現した位置
 */
@Suppress("unused", "RedundantVisibilityModifier")
public fun lowerBound(xs: IntArray, key: Int): Int {
    val xs2 = arrayOfNulls<Int>(xs.size)
    for (i in xs.indices) {
        xs2[i] = xs[i]
    }
    return lowerBound(xs2, key)
}

@Suppress("unused", "RedundantVisibilityModifier")
public fun lowerBound(xs: Array<Int?>, key: Int): Int {
    val lowerBoundComparator = LowerBoundComparator<Int>()
    val result = Arrays.binarySearch(xs, key, lowerBoundComparator)
    return if (result >= 0) result else result.inv()
}

/**
 * @param xs  Integer配列
 * @param key 探索する値
 * @return 「指定した値より大きい要素」が初めて出現した位置
 */
@Suppress("unused", "RedundantVisibilityModifier")
public fun upperBound(xs: IntArray, key: Int): Int {
    val xs2 = arrayOfNulls<Int>(xs.size)
    for (i in xs.indices) {
        xs2[i] = xs[i]
    }
    return upperBound(xs2, key)
}

@Suppress("unused", "RedundantVisibilityModifier")
public fun upperBound(xs: Array<Int?>, key: Int): Int {
    val upperBoundComparator = UpperBoundComparator<Int>()
    val result = Arrays.binarySearch(xs, key, upperBoundComparator)
    return if (result >= 0) result else result.inv()
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

internal class LowerBoundComparator<T : Comparable<T>?> : Comparator<T> {
    override fun compare(x: T, y: T): Int {
        return if (x!! >= y) 1 else -1
    }
}

internal class UpperBoundComparator<T : Comparable<T>?> : Comparator<T> {
    override fun compare(x: T, y: T): Int {
        return if (x!! > y) 1 else -1
    }
}