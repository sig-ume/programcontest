package jp.sigre.contest.template.b

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.concurrent.TimeUnit

class MainTest {

    @Test
    @Throws(Exception::class)
    fun 入力例_1() {
        val input = "4" + System.lineSeparator() +
                "1 1 3 2"
        val output = "3"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_2() {
        val input = "3" + System.lineSeparator() +
                "1 1 1"
        val output = "0"
        assertIO(input, output)
    }

    @Test
    @Throws(Exception::class)
    fun 入力例_3() {
        val input = "10" + System.lineSeparator() +
                "2 2 4 1 1 1 4 2 2 1"
        val output = "8"
        assertIO(input, output)
    }

    @Throws(Exception::class)
    private fun assertIO(input: String, output: String) {
        TimeUnit.MILLISECONDS.sleep(100)
        val `in` = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        main()
        Assert.assertThat(out.toString(), CoreMatchers.`is`(output + System.lineSeparator()))
    }
}
