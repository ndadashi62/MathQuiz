package com.example.mathquizapp

import android.R.attr.key
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        editTextUserScore.setText(intent.getStringExtra("key"))



        btnBack.setOnClickListener {
            back()

        }
        btnShow.setOnClickListener {
            showListofAnswers()
        }
    }

    fun back() {

        val intentBack = Intent(this@ResultActivity, MainActivity::class.java)
        val username: String = editTextUsername.text.toString()
        val score = editTextUserScore.text.toString()
        intentBack.putExtra("nameandscore", "$username$score")

        startActivity(intentBack)

    }

    fun showListofAnswers() {

        var answerList = intent.getStringArrayListExtra("scorelistArray")


        var showingMesage = ""
        answerList?.forEach { x ->
            showingMesage += x + "\n"
        }

        textViewScoreList.setText(showingMesage)


    }
}

