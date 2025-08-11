package secton3

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    for( number in numbers) {
        println("Number: $number")
    }

    // forEach를 사용하여 각 요소를 출력
    numbers.forEach { number ->
        println("Number: $number")
    }

    // forEachIndexed를 사용하여 인덱스와 함께 각 요소를 출력
    numbers.forEachIndexed { index, number ->
        println("Index: $index, Number: $number")
    }

    // forEachIndexed를 사용하여 인덱스와 함께 각 요소를 출력 (람다식)
    numbers.forEachIndexed { index, number -> println("Index: $index, Number: $number") }
}