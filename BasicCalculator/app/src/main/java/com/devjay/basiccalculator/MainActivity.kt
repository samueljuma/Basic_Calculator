package com.devjay.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.devjay.basiccalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var firstNumber: Double =0.0
    var secondNumber: Double =0.0
    var myAnswer: Double = 0.0
    var operator: Char =' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners ()
    }

    private fun setListeners() {
        val clickableButtons: List<View> = listOf(btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,
                    btn_7,btn_8,btn_9,btn_0,minus_btn,multiply_btn,modulus_btn,
                    plus_minus_btn,btn_plus,divide_btn,clear_btn, detele_btn,btn_dot,equals_btn)
        for (item in clickableButtons){
            item.setOnClickListener { response(it) }
        }
    }

    private fun response(view: View) {
        binding.apply {
            when (view){
                btn_0 -> input_editText.text = input_editText.text.append("0")
                btn_1 -> input_editText.text = input_editText.text.append("1")
                btn_2 -> input_editText.text = input_editText.text.append("2")
                btn_3 -> input_editText.text = input_editText.text.append("3")
                btn_4 -> input_editText.text = input_editText.text.append("4")
                btn_5 -> input_editText.text = input_editText.text.append("5")
                btn_6 -> input_editText.text = input_editText.text.append("6")
                btn_7 -> input_editText.text = input_editText.text.append("7")
                btn_8 -> input_editText.text = input_editText.text.append("8")
                btn_9 -> input_editText.text = input_editText.text.append("9")
                btn_dot -> input_editText.text = input_editText.text.append(".")
                btn_plus -> {
                    firstNumber = if(myAnswer == 0.0){
                        input_editText.text.toString().toDouble()
                    }else{ myAnswer }
                    operator = '+'
                    input_editText.setText("")
                }
                minus_btn -> {
                    firstNumber = if(myAnswer == 0.0){
                        input_editText.text.toString().toDouble()
                    }else{ myAnswer }
                    operator = '-'
                    input_editText.setText("")
                }
                clear_btn -> {input_editText.setText(""); result_textView.text=""}
                equals_btn -> {
                    secondNumber = input_editText.text.toString().toDouble()
                    myAnswer = when (operator){
                        '+' -> firstNumber + secondNumber
                        '-' -> firstNumber -secondNumber
                        'x' -> firstNumber * secondNumber
                        '/' -> firstNumber / secondNumber
                        '%' -> firstNumber % secondNumber
                        else -> firstNumber
                    }


                    result_textView.text = myAnswer.toString()

                }

                else -> input_editText.setText("5")
            }
        }

    }
}
