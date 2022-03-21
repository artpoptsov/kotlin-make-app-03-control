// Task 2
fun main() {

    println(commission(currentAmount = 10_000_00, cardType = "Vk Pay", lastAmount = 1_00))

}

fun commission(cardType: String = "Vk Pay", lastAmount: Int = 0, currentAmount: Int): Int {

    val commission = when (cardType) {
        "Mastercard", "Maestro" -> {
            when (lastAmount) {
                in 0..75_000_00 -> 0
                else -> currentAmount * 60 / 10_000 + 20_00
            }
        }
        "Visa", "Мир" -> {
            when {
                currentAmount * 75 / 10_000 > 35_00 -> currentAmount * 75 / 10_000
                else -> 35_00
            }
        }
        "Vk Pay" -> 0
        else -> 0
    }
    return commission
}
