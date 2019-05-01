package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    var total = 0
    var secondElement = 0
    var operator = ""
    var operatorClicked = false
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val button1: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button10: Button = findViewById(R.id.button10)
        val button11: Button = findViewById(R.id.button11)
        val button12: Button = findViewById(R.id.button12)
        val button13: Button = findViewById(R.id.button13)
        val button14: Button = findViewById(R.id.button14)
        val button15: Button = findViewById(R.id.button15)
        val button16: Button = findViewById(R.id.button16)
        val clearButton: Button = findViewById(R.id.button17)

        clickButtonNumber(button1)
        clickButtonNumber(button2)
        clickButtonNumber(button3)
        clickButtonNumber(button4)
        clickButtonNumber(button5)
        clickButtonNumber(button6)
        clickButtonNumber(button7)
        clickButtonNumber(button8)
        clickButtonNumber(button9)
        clickButtonNumber(button10)
        clickButtonOperator(button11)
        clickButtonOperator(button12)
        clickButtonOperator(button13)
        clickButtonOperator(button14)
        clickButtonOperator(button15)

        clearButton.setOnClickListener{ resetStatus() }

    }

    private fun clickButtonOperator(button: Button) {
        button.setOnClickListener {
            println("$operatorClicked")
            if (operator == "+") {
                total += secondElement
            }
            if (operator == "-") {
                total -= secondElement
            }
            if (operator == "x") {
                println("$operatorClicked")
                total *= secondElement
            }
            if (operator == "÷" && secondElement != 0) {
                total /= secondElement
            }
            if (operator == "") {
                total = secondElement
            }
            println("$operatorClicked")
            textView?.text = total.toString()
            secondElement = 0
            operator = button.text.toString()
            operatorClicked = true

        }
    }

    private fun clickButtonNumber(button: Button) {
        button.setOnClickListener {
            if (operator == "=") {
                resetStatus()
            }
            if (secondElement == 0) {
                textView?.text = ""
            }
            textView?.append(button.text)
            secondElement = textView?.text.toString().toInt()
            operatorClicked = false
        }

    }

    private fun resetStatus() {
        total = 0
        secondElement = 0
        operator = ""
        textView?.text = total.toString()
    }
}
