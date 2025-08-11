package secton3

// .. 연산자가 등차수열을 만들어줌.
// while문은 jav와 동일함.
// downTo, step 도 함수임.

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    for( number in numbers) {
        println("Number: $number")
    }

    for (number in 1..5) {
        println("Number: $number")
    }

    for (number in 1..5 step 2) {
        println("Number: $number")
    }

    for (number in  5 downTo  1) {
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