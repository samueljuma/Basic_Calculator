package com.devjay.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.devjay.basiccalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0
    private var myAnswer: Double = 0.0
    private var operator: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableButtons: List<View> = listOf(
            btn_1, btn_2, btn_3, btn_4, btn_5, btn_6,
            btn_7, btn_8, btn_9, btn_0, minus_btn, multiply_btn, modulus_btn,
            plus_minus_btn, btn_plus, divide_btn, clear_btn, detele_btn, btn_dot, equals_btn
        )
        for (item in clickableButtons) {
            item.setOnClickListener { response(it) }
        }
    }

    private fun response(view: View) {
        binding.apply {
            when (view) {
                btn_0 -> btnOnclick("0")
                btn_1 -> btnOnclick("1")
                btn_2 -> btnOnclick("2")
                btn_3 -> btnOnclick("3")
                btn_4 -> btnOnclick("4")
                btn_5 -> btnOnclick("5")
                btn_6 -> btnOnclick("6")
                btn_7 -> btnOnclick("7")
                btn_8 -> btnOnclick("8")
                btn_9 -> btnOnclick("9")
                btn_dot -> btnOnclick(".")
                btn_plus -> myOperation('+')
                minus_btn -> myOperation('-')
                multiply_btn -> myOperation('x')
                divide_btn -> myOperation('/')
                modulus_btn -> myOperation('%')
                clear_btn -> clear()
                equals_btn -> equalsOperation()
            }
        }

    }

    private fun myOperation(myOperator: Char) {
        equalsOperation()
        firstNumber = if (myAnswer == 0.0) {
            input_editText.text.toString().toDouble()
        } else {
            myAnswer
        }
        operator = myOperator
        input_editText.setText("")
    }

    private fun clear() {
        input_editText.setText(""); result_textView.text = ""
        firstNumber = 0.0
        myAnswer = 0.0
        secondNumber = 0.0
        operator = ' '
    }

    private fun equalsOperation() {
        if (input_editText.text.toString() == ""){
            secondNumber =0.0
            operator =' '
        }else {
            secondNumber = input_editText.text.toString().toDouble()}

        myAnswer = when (operator) {
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            'x' -> firstNumber * secondNumber
            '/' -> firstNumber / secondNumber
            '%' -> firstNumber % secondNumber
            else -> secondNumber
        }
        result_textView.text = myAnswer.toString()
        // clear where necessary
        input_editText.setText("")
        firstNumber = 0.0
        secondNumber = 0.0
        operator = ' '
    }

    private fun btnOnclick(number: String) {
        input_editText.text = input_editText.text.append(number)
    }

}
