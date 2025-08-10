package section2

/**
 * 타입 학습
 */
fun main() {
    var number1 = 10L;
    val number2: Long = number1.toLong();

    println("이름: $number1 $number2")

    val indent = """
        이건
        Indent라는
        거다.
    """.trimIndent()
    println(indent)
    println(indent[2])

    val k = number1 >= 10L ? "10 이상" : "10 미만"
    val y = if (number1 >= 10L) "10 이상" else "10 미만"
}

fun printAgeIfPerson(obj: Any) {
    val person = obj as? Person
    println(person?.age)
}