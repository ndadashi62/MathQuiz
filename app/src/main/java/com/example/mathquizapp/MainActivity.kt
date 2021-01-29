package com.example.mathquizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {




    var operator: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGenerate.setOnClickListener {
            generate()


        }

    }

    //toDO 1 :making generate function for generatin the operations
    fun generate() {




        val random=Random.nextInt(4)


         when (random) {
             0 -> {
                 operator = "+"
                 var randomAdd1 = Random.nextInt(10)
                 var randomAdd2 = Random.nextInt(10)

                 textViewDisplayGenerate.setText(("$randomAdd1+$randomAdd2"))


             }
             1 -> {
                 operator = "-"
                 var randomMinus1=Random.nextInt(10)
                 var randonMinus2= Random.nextInt(10)
                 textViewDisplayGenerate.setText(("$randomMinus1-$randonMinus2"))


             }
            2 -> {
                operator = "*"
                var randomMultiple1=Random.nextInt(10)
                var randomMultiple2= Random.nextInt(10)
                textViewDisplayGenerate.setText(("$randomMultiple1*$randomMultiple2"))



            }
            3 -> {
                operator = "/"
                var randomDivision1=Random.nextInt(10)
                var randomDivision2= Random.nextInt(10)
                textViewDisplayGenerate.setText(("$randomDivision1*$randomDivision2"))

            }
            else-> operator="?"


        }



    }


}
