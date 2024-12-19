package ooo.chko.tests

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
                "Какой класс в Team Fortress 2 используется для атаки на расстоянии?",
                listOf("Пулеметчик", "Снайпер", "Шпион", "Инженер"),
                1, R.drawable.tf2
            ),
            Question(
                "Какой класс умеет строить здания?",
                listOf("Пулеметчик", "Снайпер", "Шпион", "Инженер"),
                3, R.drawable.tf2_2
            ),
            Question(
                "Какой класс лучше всего подходит для поддержки команды?",
                listOf("Доктор", "Шпион", "Солдат", "Инженер"),
                0, R.drawable.tf2_3
            ),
            Question(
                "Какой класс может телепортировать своих товарищей по команде?",
                listOf("Снайпер", "Инженер", "Доктор", "Пулеметчик"),
                1, R.drawable.tf2_4
            ),
            Question(
                "Какой класс умеет использовать невидимость?",
                listOf("Шпион", "Инженер", "Солдат", "Пулеметчик"),
                0, R.drawable.tf2_5
            )
        )
    }
}