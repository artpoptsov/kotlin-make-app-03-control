// Task 1
fun main() {

    var secondsAgo = 45
    val textToPrint1 = agoToText(secondsAgo)
    textToConsole(textToPrint1)

    secondsAgo = 124
    val textToPrint2 = agoToText(secondsAgo)
    textToConsole(textToPrint2)

    secondsAgo = 12_400
    val textToPrint3 = agoToText(secondsAgo)
    textToConsole(textToPrint3)

    secondsAgo = 124_000
    val textToPrint4 = agoToText(secondsAgo)
    textToConsole(textToPrint4)

    secondsAgo = 221_362
    val textToPrint5 = agoToText(secondsAgo)
    textToConsole(textToPrint5)

    secondsAgo = 12_400_000
    val textToPrint6 = agoToText(secondsAgo)
    textToConsole(textToPrint6)
}

fun agoToText(secondsAgo: Int): String {

    val resultText = when (secondsAgo) {
        in 0..60 -> {
            "только что"
        }
        in 61..60 * 60 -> {
            val minutes = calculateOfMinute(secondsAgo)
            val case = minuteCases(secondsAgo)
            "$minutes минут$case назад"
        }
        in 60 * 60 + 1..24 * 60 * 60 -> {
            val hours = calculateOfHour(secondsAgo)
            val case = hourCases(secondsAgo)
            "$hours час$case назад"
        }
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> {
            "сегодня"
        }
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> {
            "вчера"
        }
        else -> "давно"
    }
    return "Был(а) $resultText"
}

fun textToConsole (textToPrint: String) {
    println(textToPrint)
}

fun calculateOfMinute(secondsAgo: Int): Int {
    return secondsAgo / 60
}

fun calculateOfHour(secondsAgo: Int): Int {
    return secondsAgo / 3_600
}

fun minuteCases(secondsAgo: Int): String {
    val case = when (calculateOfMinute(secondsAgo)) {
        1 -> "у"
        in 2..4, in 22..24, in 32..34, in 42..44 -> "ы"
        in 5..20, in 25..60 -> ""
        21 -> "у"
        else -> ""
    }
    return case
}

fun hourCases(secondsAgo: Int): String {
    val case = when (calculateOfHour(secondsAgo)) {
        1, 21 -> ""
        in 2..4, in 22..24 -> "а"
        in 5..20, in 25..60 -> "ов"
        else -> ""
    }
    return case
}