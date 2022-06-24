package jp.sigre.contest.template.c

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
        val input = "3 4 6 3 3 7"
        val output = "1"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_2() {
        val input = "3 4 5 6 7 8"
        val output = "0"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_3() {
        val input = "5 13 10 6 13 9"
        val output = "120"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_4() {
        val input = "20 25 30 22 29 24"
        val output = "30613"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_5() {
        val input = "3 3 3 3 3 3"
        val output = "1"
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
