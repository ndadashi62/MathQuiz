package com.example.mathquizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGenerate.setOnClickListener {
            generate()
        }
        btnValidate.setOnClickListener {
            validate()
        }
    }


    //toDO 1 :making generate function for generatin the operations
    fun generate() {

        val random = Random.nextInt(4)
        var randomNum1 = Random.nextInt(10)
        var randomNum2 = Random.nextInt(10)
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
        var result = editTextUserAnswer.text.toString()





    }

}
