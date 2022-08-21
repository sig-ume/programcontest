package jp.sigre.contest.abc

import jp.sigre.contest.Scanner
import java.io.PrintWriter
import kotlin.math.max
import kotlin.math.min

@Suppress("unused", "PrivatePropertyName")
class ABC263 {

    private var N = 0
    var result = 0

    fun a() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val az = IntArray(5) { sc.nextInt() }
        az.sort()
        val max = az[4]
        val min = az[0]

        var maxCount = 0
        var minCount = 0
        for (a in az) {
            if (a == max) maxCount++
            if (a == min) minCount++
        }

        val result =
            if (max(maxCount, minCount) == 3 && min(maxCount, minCount) == 2) "Yes"
            else "No"

        writer.println(result)
        writer.flush()
    }

    fun b() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val PS = mutableMapOf<Int, Int>()

        for (i in 2..N) {
            PS[i] = sc.nextInt()
        }

        var result = 0

        var now = N
        for (i in 1..N) {
            now = PS[now]!!
            result++
            if (now == 1) break
        }

        writer.println(result)
        writer.flush()
    }

    fun c() {
        val writer = PrintWriter(System.out, false)
        val sc = Scanner()
        val N = sc.nextInt()
        val M = sc.nextInt()

        val az = IntArray(M)
        for (i in 0 until M) {
            az[i] = i + 1
        }

        val result = mutableListOf<String>()
        for (i in 1 until 1.shl(M)) {
            val oneIdx = BitwiseOperation.getOneIdx(i, M)
            if (oneIdx.size != N) continue
            var str = ""
            for (idx in oneIdx) {
                val a = if (az[idx] == 10) {
                    "zz"
                } else {
                    az[idx].toString()
                }
                str += "$a "
            }
            result.add(str)
        }

        result.sort()
        for (str in result) {
            val s = str.replace("zz", "10")
            writer.println(s)
        }
        writer.flush()
    }

    object BitwiseOperation {

        @OptIn(ExperimentalStdlibApi::class)
        fun getOneIdx(num: Int, length: Int): MutableList<Int> {
            val result = mutableListOf<Int>()
            for (i in 0 until length) {
                if (getBit(num, i) == 1) result.add(i)
            }
            return result
        }

        // numのiビット目の値(0もしくは1)を取得する
        @kotlin.ExperimentalStdlibApi
        fun getBit(num: Int, i: Int): Int =
            (num and createMask(i, i)).countOneBits()

        // from〜toビット目が1(もしくは0)で、それ以外が0(もしくは1)となる整数を取得する
        @kotlin.ExperimentalStdlibApi
        fun createMask(from: Int, to: Int, shouldSet: Boolean = true): Int {
            require(from in 0 until Int.SIZE_BITS) { "from must be in the range of int bit size." }
            require(to in 0 until Int.SIZE_BITS) { "to must be in the range of int bit size." }
            require(from <= to) { "Incorrect indices combination. from: $from, to: $to" }

            val mask = (allOneBits shl (to + 1)).inv() and (allOneBits shl from)
            return if (shouldSet) mask else mask.inv()
        }

        private const val allOneBits: Int = 0.inv()
    }
}