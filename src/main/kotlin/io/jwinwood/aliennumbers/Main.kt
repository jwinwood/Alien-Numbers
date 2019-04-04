package io.jwinwood.aliennumbers

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(args : Array<String>) {
    val `in` = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val t = `in`.nextInt()  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (i in 1..t) {
        val number = `in`.next()
        val sourceLanguage = `in`.next()
        val targetLanguage = `in`.next()
        val result = convert(number, sourceLanguage.toCharArray().toList(), targetLanguage.toCharArray().toList())
        println("Case #$i: $result")
    }
}
