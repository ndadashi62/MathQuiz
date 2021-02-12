package com.example.mathquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var listViewScore: ListView
    var randomNum1: Int = 0
    var randomNum2: Int = 0
    var operator: String = ""
    var userScore = 0
    var totalQuestionvalidated = 0
    var correctAnswers: String = ""
    var incorectAnswers: String = ""
    var answerList = ArrayList<MathQuizLine>()
    var userAnswer: Int = 0
    var answer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewMathQuiz.setText(intent.getStringExtra("nameandscore"))



        btnGenerate.setOnClickListener {
            totalQuestionvalidated++
            generate()
        }
        btnValidate.setOnClickListener {

            validate()
            editTextUserAnswer.text.clear()

        }
        btnClear.setOnClickListener {
            clear()
        }
        btnScore.setOnClickListener {
            lucnhResultActivity()

        }




        btnOne.setOnClickListener {
            var txt1 = editTextUserAnswer.text.toString() + btnOne.text.toString()
            editTextUserAnswer.setText(txt1).toString()
        }

        btntwo.setOnClickListener {
            var txt2 = editTextUserAnswer.text.toString() + btntwo.text.toString()
            editTextUserAnswer.setText(txt2).toString()
        }
        btnthree.setOnClickListener {
            var txt3 = editTextUserAnswer.text.toString() + btnthree.text.toString()
            editTextUserAnswer.setText(txt3).toString()
        }
        btnFour.setOnClickListener {
            var txt4 = editTextUserAnswer.text.toString() + btnFour.text.toString()
            editTextUserAnswer.setText(txt4).toString()
        }
        btnFive.setOnClickListener {
            var txt5 = editTextUserAnswer.text.toString() + btnFive.text.toString()
            editTextUserAnswer.setText(txt5).toString()
        }
        btnSix.setOnClickListener {
            var txt6 = editTextUserAnswer.text.toString() + btnSix.text.toString()
            editTextUserAnswer.setText(txt6).toString()
        }
        btnSeven.setOnClickListener {
            var txt7 = editTextUserAnswer.text.toString() + btnSeven.text.toString()
            editTextUserAnswer.setText(txt7).toString()

        }
        btnEight.setOnClickListener {
            var txt8 = editTextUserAnswer.text.toString() + btnEight.text.toString()
            editTextUserAnswer.setText(txt8).toString()

        }
        btnNine.setOnClickListener {
            var txt9 = editTextUserAnswer.text.toString() + btnNine.text.toString()
            editTextUserAnswer.setText(txt9).toString()

        }
        btnZero.setOnClickListener {
            var txtZero = editTextUserAnswer.text.toString() + btnZero.text.toString()
            editTextUserAnswer.setText(txtZero).toString()

        }
        btnDot.setOnClickListener {
            var txtDot = editTextUserAnswer.text.toString() + btnDot.text.toString()
            editTextUserAnswer.setText(".").toString()
        }
        btnMinus.setOnClickListener {
            var txtMinus = editTextUserAnswer.text.toString() + btnMinus.text.toString()
            editTextUserAnswer.setText("-").toString()
        }
        btnFinish.setOnClickListener {
            finish()
        }
    }


    //toDO 1 :making generate function for generatin the operations

    private fun generate() {


        val random = Random.nextInt(4)
        randomNum1 = Random.nextInt(1, 10)
        randomNum2 = Random.nextInt(1, 10)
        when (random) {
            0 -> {
                operator = "+"
            }
            1 -> {
                operator = "-"
            }
            2 -> {
                operator = "*"
            }
            3 -> {
                operator = "/"
            }
            else -> operator = "?"
        }
        textViewDisplayGenerate.setText(("$randomNum1 $operator $randomNum2"))

    }

    //  toDO 2 :making validate function for validatin

    fun validate() {
        userAnswer = editTextUserAnswer.text.toString().toInt()
        when (operator) {
            "+" -> answer = randomNum1 + randomNum2
            "-" -> answer = randomNum1 - randomNum2
            "*" -> answer = randomNum1 * randomNum2
            "/" -> answer = randomNum1 / randomNum2
        }
        var mathQuizLine = MathQuizLine(randomNum1, randomNum2, operator, answer, userAnswer )
        if (answer == userAnswer) {
            textViewDisplayGenerate.setText("Correct :)").toString()
            Toast.makeText(
                this,
                "$randomNum1 $operator $randomNum2=$userAnswer your answer $answer is correct",
                Toast.LENGTH_SHORT
            ).show()
            userScore++
        } else {
            (textViewDisplayGenerate.setText("Incorrect :(")).toString()
            Toast.makeText(
                this,
                "$randomNum1 $operator $randomNum2 = $userAnswer  your answer $answer is incorrect",
                Toast.LENGTH_SHORT
            ).show()
        }
        answerList.add(mathQuizLine)

    }

    fun clear() {
        editTextUserAnswer.text.clear()
    }

    fun lucnhResultActivity() {


        var percentage = ((userScore * 100 / totalQuestionvalidated)).toString() + "%"


        //passing score to other Activity
        var scoreIntent = Intent(this@MainActivity, ResultActivity::class.java)
        scoreIntent.putExtra("key", percentage)

       // passing generated questions to other Activity
        var bundle = Bundle()
        bundle.putSerializable("bundleContent", answerList)
        scoreIntent.putExtra("scorelistArray", bundle)

        startActivity(scoreIntent)


    }



//a-b
//    a>b +
//    a==b 0
//    a<b -

}




