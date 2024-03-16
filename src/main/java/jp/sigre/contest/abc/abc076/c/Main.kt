package jp.sigre.contest.abc.abc076.c

import java.io.PrintWriter
import java.util.*

fun main() {
    val writer = PrintWriter(System.out, false)
    val sc = Scanner()
    val SDash = sc.next()
    val T = sc.next()

    val regex = SDash.replace("?", "[a-z]").toRegex()
    val mutableListOf = mutableListOf<String>()
    generateAlphabetStrings(SDash.length, "", T, mutableListOf, regex)

    writer.println(mutableListOf[0])
    writer.flush()
}

fun generateAlphabetStrings(
    length: Int,
    prefix: String = "",
    t: String,
    results: MutableList<String>,
    regex: Regex
): MutableList<String> {
    if (length == 0) {
        if (prefix.contains(t) && regex.matches(prefix)) {
            results.add(prefix)
        }
    } else {
        for (c in 'a'..'z') {
            generateAlphabetStrings(length - 1, prefix + c, t, results, regex)
        }
    }
    return results
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