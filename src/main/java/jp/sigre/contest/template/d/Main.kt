package jp.sigre.contest.template.d

import java.io.PrintWriter
import java.util.*
import kotlin.math.sqrt

var N = 0
var tmp = 0
var result = 0

fun main() {
    val writer = PrintWriter(System.out, false)

    N = nextInt()

    println(decom(N))

    for (i in 1..N) {
        val decom = decom(i)

        val eachCount = decom.groupingBy { it }.eachCount()

        var c = 1
        for (value in eachCount.values) {
            c *= value * value
        }

        result += c
    }

    println(result)

    writer.flush()
}

fun getPrimeArrayUnder(maxNumber: Int): List<Int> {
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

// 素因数分解
fun decom(value: Int): List<Int> {
    if (value == 1) return listOf(1)
    val max = Math.sqrt(value.toDouble()).toInt()
    return getPrimeArrayUnder(max).filter { value % it == 0 }
}


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