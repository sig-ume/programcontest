package jp.sigre.contest.coderbyte.monoxer.b

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun SearchingChallenge(strArr: Array<String>): String {
    val hashMap = HashMap<String, Int>()
    // code goes here
    for (str in strArr) {
        val split = str.split(":")
        val key = split[0]
        val value = split[1].toInt()
        if (!hashMap.contains(key)) {
            hashMap[key] = value
        } else {
            hashMap[key] = hashMap[key]!! + value
        }
    }
    val list = hashMap.map { entry -> entry.key + ":" + entry.value }.sorted()
    var result = ""
    var firstTiming = true
    for (s in list) {
        if (s.endsWith(":0")) continue
        if (!firstTiming) result += ","
        firstTiming = false
        result += "$s"
    }

    return result

}

fun MathChallenge(num: Int): String {
    return if (isFibonacci(num)) "yes" else "no"
}

fun isSquare(num: Int): Boolean {

    val s = sqrt(num.toDouble()).toInt()
    return (num == s * s)
}

fun isFibonacci(num: Int): Boolean {
    return isSquare(5 * num * num + 4)
            || isSquare(5 * num * num - 4)
}

fun ArrayChallenge(arr: Array<Int>): Int {
    var valOnLong = arr[0]
    var valOnShort = 0
    var valOnNow = arr[0]
    var maxGain = 0

    for (dollar in arr) {
        // 株価が下がればLongチャンス
        if (valOnNow >= dollar) {
            valOnLong = min(valOnLong, dollar)
        } else {
            // 株価が今より上がればShortチャンス
            valOnShort = max(valOnShort, dollar)
            maxGain = max(valOnShort - valOnLong, maxGain)
        }
        // 売りタイミングより安くなったら売りタイミングリセット
        if (valOnShort > dollar) {
            valOnShort = 0
        }

        valOnNow = dollar


    }

    return if (maxGain > 0) maxGain
    else -1

}

fun main() {
    println(MathChallenge(4))
}