package com.example.quizmaster.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizmaster.Domain.QuestionModel
import com.example.quizmaster.R
import com.example.quizmaster.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val window:Window =this@MainActivity.window
        window.statusBarColor=ContextCompat.getColor(this@MainActivity, R.color.grey)

        binding.apply {
            singleBtn.setOnClickListener {
                val intent=Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //list of questions
    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(1,
                "Какой элемент имеет химический символ \"O\"?",
                "Азот",
                "Кислород",
                "Углерод",
                "Водород",
                "b",
                5,
                "p_1",
                null
            )
        )
        question.add(
            QuestionModel(2,
                "Кто является автором теории относительности?",
                "Альберт Эйнштейн",
                "Исаак Ньютон",
                "Галилео Галилей",
                "Макс Планк",
                "a",
                5,
                "p_2",
                null
            )
        )
        question.add(
            QuestionModel(3,
                "Какое явление объясняет отклонение света в гравитационном поле?",
                "Эффект Доплера",
                "Гравитационное линзирование",
                "Фотоэлектрический эффект",
                "Рефракция",
                "b",
                5,
                "p_3",
                null
            )
        )
        question.add(
            QuestionModel(4,
                "Какое событие произошло в 1917 году в России?",
                "Февральская революция",
                "Гражданская война",
                "Подписание Брестского мира",
                "Октябрьская революция",
                "d",
                5,
                "p_4",
                null
            )
        )
        question.add(
            QuestionModel(5,
                "Какой древний город был столицей Вавилонского царства?",
                "Урук",
                "Ниневия",
                "Вавилон",
                "Тир",
                "c",
                5,
                "p_5",
                null
            )
        )
        question.add(
            QuestionModel(6,
                "Какой знаменитый документ был подписан в 1215 году в Англии?",
                "Билль о правах",
                "Магна Карта",
                "Конституция",
                "Великая хартия вольностей",
                "b",
                5,
                "p_6",
                null
            )
        )
        question.add(
            QuestionModel(7,
                "Какой фильм получил Оскар за лучший фильм в 1994 году?",
                "Список Шиндлера",
                "Криминальное чтиво",
                "Парк Юрского периода",
                "Форрест Гамп",
                "d",
                5,
                "p_7",
                null
            )
        )
        question.add(
            QuestionModel(8,
                "Какой режиссер снял фильм \"Психо\"?",
                "Альфред Хичкок",
                "Мартин Скорсезе",
                "Стэнли Кубрик",
                "Фрэнсис Форд Коппола",
                "a",
                5,
                "p_8",
                null
            )
        )
        question.add(
            QuestionModel(9,
                "Какой известный русский балет был написан Петром Ильиным Чайковским?",
                "Щелкунчик",
                "Спящая красавица",
                "Лебединое озеро",
                "Ромео и Джульетта",
                "с",
                5,
                "p_9",
                null
            )
        )
        question.add(
            QuestionModel(10,
                "Какой известный русский художник создал картины \"Утро в сосновом лесу\"?",
                "Иван Шишкин",
                "Константин Коровин",
                "Илья Репин",
                "Василий Суриков",
                "a",
                5,
                "p_10",
                null
            )
        )
        return question
    }
}