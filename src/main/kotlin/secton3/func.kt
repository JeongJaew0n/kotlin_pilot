package secton3

// Lec 08. 코틀ㄹㄴ에서 함수를  다루는 방법

fun main() {
    val numberStrings = arrayOf("one", "two", "three")

    // * 필수임.
    printAll(*numberStrings)
}

// 반환 타입 생략  불가.
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// = 연산자 쓰면 반환타입 생략 가능.
fun min(a: Int, b: Int) = if (a < b) a else b

// default 파라미터
fun repeat(str: String, times: Int = 1, useNewLinBoolean: Boolean = true): String {
    return str.repeat(times)
}

// named 파라미터
fun printMessage() {
    repeat(str = "hello")
}

// 가변인자
fun printAll(vararg strings: String) {
    for (s in strings) {
        println(s)
    }
}