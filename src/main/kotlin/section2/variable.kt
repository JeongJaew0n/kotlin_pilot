package section2

/**
 * 연산자 학습
 */
fun main() {
    val person = Person("John")

    startsWithA(person.name ?: "Unknown")
}

fun startsWithA(name: String): Boolean {
    return name.startsWith("A")
}