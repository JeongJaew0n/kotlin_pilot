package secton3

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {

}

// expression 이란 개념이 중요함.
// expression vs statement
// expression: 값으로 평가되는 코드 블록
// statement: 실행되는 코드 블록
// 코틀린은 expression 기반 언어로, 대부분의 코드가 expression으로 평가됨.
// 예를 들어, if 문은 expression으로 사용될 수 있음.
// try catch 문도 expression으로 사용될 수 있음.

fun parseIntOrThrow(input: String): Int {
    return try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid number format: $input", e)
    }
}

// 이거이거 보면 FilerReader 에서 FileNotFoundException 던져야 하는데, 안 던저져도 되죠?

class FilePrinter {
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader  = BufferedReader(FileReader(file));
        println(reader.readLine())
        reader.close()

        // try-with-resources 사라짐. 대신 use 함수를 사용하여 자동으로 자원을 해제할 수 있음.
        BufferedReader(FileReader(file)).use { readerIn ->
            println(readerIn.readLine())
        }
    }
}