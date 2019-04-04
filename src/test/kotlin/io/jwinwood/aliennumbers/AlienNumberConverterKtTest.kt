package io.jwinwood.aliennumbers

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class AlienNumberConverterKtTest {

    /*
        9 0123456789 oF8        => Foo
        Foo oF8 0123456789      => 9
        13 0123456789abcdef 01  => 10011
        CODE O!CDE? A?JM!.      => JAM!
     */

    val decimalNumbers = listOf('0','1','2','3','4','5','6','7','8','9')

    @Test
    fun `test 0 returns 0 for numerals (0, 1)`() {
        assertThat(convert("0", decimalNumbers, listOf('0', '1')), equalTo("0"))
    }

    @Test
    fun `test 1 returns 1 for numerals (0, 1)`() {
        assertThat(convert("1", decimalNumbers, listOf('0', '1')), equalTo("1"))
    }

    @Test
    fun `test 16 returns 10000 for numerals (0, 1)`() {
        assertThat(convert("16", decimalNumbers, listOf('0', '1')), equalTo("10000"))
    }

    @Test
    fun `test 1234 returns 10011010010 for numerals (0, 1)`() {
        assertThat(convert("1234", decimalNumbers, listOf('0', '1')), equalTo("10011010010"))
    }

    @Test
    fun `test 9 in (0, 1, 2, 3, 4, 5, 6, 7, 8, 9) converts to Foo for (o, F, 8)`() {
        assertThat(convert("9", decimalNumbers, listOf('o', 'F', '8')), equalTo("Foo"))
    }

    @Test
    fun `test 13 in (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f) converts to 10011 for (0, 1)`() {
        assertThat(
                convert(number ="13",
                        sourceLanguage = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'),
                        targetLanguage = listOf('0', '1')),
                equalTo("10011")
        )
    }

    @Test
    fun `test CODE in (O, !, C, D, E, ?) converts to JAM! for (A, ?, J, M, !, period)`() {
        assertThat(
                convert(number = "CODE",
                        sourceLanguage = listOf('O', '!', 'C', 'D', 'E', '?'),
                        targetLanguage = listOf('A', '?', 'J', 'M', '!', '.')),
                equalTo("JAM!")
        )
    }
}