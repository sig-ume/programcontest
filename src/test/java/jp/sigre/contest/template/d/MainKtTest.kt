package jp.sigre.contest.template.d

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
        val input = "3" + System.lineSeparator() +
                "10 20" + System.lineSeparator() +
                "20 30" + System.lineSeparator() +
                "40 50"
        val output = "10 30" + System.lineSeparator() +
                "40 50"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_2() {
        val input = "3" + System.lineSeparator() +
                "10 40" + System.lineSeparator() +
                "30 60" + System.lineSeparator() +
                "20 50"
        val output = "10 60"
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
