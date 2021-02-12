package com.example.mathquizapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MathQuizLine (
    var randNum1: Int,
    var randNum2: Int,
    var oprator:String,
    var answer:Int,
    var userAnswer:Int
) : Parcelable {
fun mytoString():String {
    if(answer==userAnswer)
    { return "$randNum1 $oprator $randNum2=$userAnswer your answer $answer is correct"}
    else
        return  "$randNum1 $oprator $randNum2=$userAnswer your answer $answer is incorrect"





}
}



