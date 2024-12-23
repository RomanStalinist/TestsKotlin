package ooo.kno.tests

import androidx.annotation.DrawableRes

data class Question(
    val text: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    @DrawableRes val imageRes: Int?
) {
    companion object {
        var questions = arrayOf(
            Question(
                "Какой тип данных используется для целых чисел в Java?",
                listOf("float", "int", "double", "char"),
                1,
                null
            ),
            Question(
                "Какой оператор используется для сравнения в Java?",
                listOf("==", "=", "!=", "!=="),
                0,
                null
            ),
            Question(
                "Какой метод используется для вывода текста в консоль в Java?",
                listOf("System.out.write", "System.print", "System.out.println", "System.out.output"),
                2,
                null
            ),
            Question(
                "Какой ключевое слово используется для объявления класса в Java?",
                listOf("class", "struct", "function", "method"),
                0,
                null
            ),
            Question(
                "Какой оператор используется для цикла 'пока' в Java?",
                listOf("for", "while", "do-while", "foreach"),
                1,
                null
            ),
            Question(
                "Какой ключевое слово используется для объявления константы в Java?",
                listOf("const", "static", "final", "constant"),
                2,
                null
            ),
            Question(
                "Какой метод используется для чтения строки из консоли в Java?",
                listOf("Scanner.read", "Scanner.nextLine", "Scanner.readLine", "Scanner.getString"),
                1,
                null
            ),
            Question(
                "Какой тип данных используется для строк в Java?",
                listOf("string", "String", "str", "text"),
                1,
                null
            ),
            Question(
                "Какой ключевое слово используется для создания объекта в Java?",
                listOf("new", "create", "make", "build"),
                0,
                null
            ),
            Question(
                "Какой оператор используется для логического И в Java?",
                listOf("&&", "||", "!", "and"),
                0,
                null
            )
        )
    }
}