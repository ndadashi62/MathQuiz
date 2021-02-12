package com.example.mathquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    var answerList: ArrayList<MathQuizLine>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        editTextUserScore.setText(intent.getStringExtra("key"))


        val bundle = intent.getBundleExtra("scorelistArray")

        val bundleContent = bundle!!.getSerializable("bundleContent")

        answerList = bundleContent as ArrayList<MathQuizLine>?

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
        var showingMesage = ""
        when(radioGroup.checkedRadioButtonId){
            R.id.radioButtonAll-> answerList?.forEach { it ->
                showingMesage += it.mytoString() + "\n"
            }

            }
        textViewScoreList.setText(showingMesage)

        }


    }







