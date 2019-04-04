package io.jwinwood.aliennumbers

fun convert(number: String, sourceLanguage: List<Char>, targetLanguage: List<Char>): String {
    val decimal = convertToDecimal(number, sourceLanguage)

    val targetBase = targetLanguage.size

    var temp = decimal

    var result = ""
    do {
        result += targetLanguage[temp % targetBase]
        temp /= targetBase
    } while (temp != 0)

    return result.reversed()
}

private fun convertToDecimal(number: String, sourceLanguage: List<Char>): Int {
    val numerals = number.length

    var result = 0
    val base = sourceLanguage.size
    var power = numerals - 1
    for (i in 0 until numerals) {
        val multiplier = Math.pow(base.toDouble(), power.toDouble()).toInt()
        val index = sourceLanguage.indexOf(number[i])
        result += index * multiplier
        --power
    }

    return result
}