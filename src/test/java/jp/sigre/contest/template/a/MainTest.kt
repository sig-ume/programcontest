package jp.sigre.contest.template.a

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {
    @Test
    @Throws(Exception::class)
    fun 入力例_1() {
        val input = "5 3" + System.lineSeparator() +
                "6 11 2 5 5" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "20" + System.lineSeparator() +
                "0"
        val output = "10" + System.lineSeparator() +
                "71" + System.lineSeparator() +
                "29"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_2() {
        val input = "10 5" + System.lineSeparator() +
                "1000000000 314159265 271828182 141421356 161803398 0 777777777 255255255 536870912 998244353" + System.lineSeparator() +
                "555555555" + System.lineSeparator() +
                "321654987" + System.lineSeparator() +
                "1000000000" + System.lineSeparator() +
                "789456123" + System.lineSeparator() +
                "0"
        val output = "3316905982" + System.lineSeparator() +
                "2811735560" + System.lineSeparator() +
                "5542639502" + System.lineSeparator() +
                "4275864946" + System.lineSeparator() +
                "4457360498"
        assertIO(input, output)
    }

    @Throws(Exception::class)
    private fun assertIO(input: String, output: String) {
        val `in` = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        main()
        Assert.assertThat(out.toString(), CoreMatchers.`is`(output + System.lineSeparator()))
    }
}
