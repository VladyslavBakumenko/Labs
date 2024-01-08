package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labs.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operand1: Double = 0.0
    private var currentOperator = ""
    private var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setNumbersClickListeners()
        setOperatorsClickListeners()
        setEqualsClickListener()
        setClearButtonListener()
    }

    private fun setClearButtonListener() {
        binding.buttonClear.setOnClickListener {
            operand1 = 0.0
            currentOperator = ""
            isNewOperation = true
            binding.editText.text.clear()
        }
    }

    private fun setNumbersClickListeners() {
        val numberButtonsList = listOf(
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.button0
        )

        for (button in numberButtonsList) {
            button.setOnClickListener {
                onNumberClick(button.text.toString())
            }
        }
    }

    private fun onNumberClick(number: String) {
        if (isNewOperation) {
            binding.editText.setText(number)
            isNewOperation = false
        } else {
            val currentText = binding.editText.text.toString()
            val newText = currentText + number
            binding.editText.setText(newText)
        }
    }

    private fun setOperatorsClickListeners() {
        val operatorButtonsList = listOf(
            binding.buttonPlus,
            binding.buttonMinus,
            binding.buttonMultiply,
            binding.buttonDivide,
        )

        for (button in operatorButtonsList) {
            button.setOnClickListener {
                onOperatorClick(button.text.toString())
            }
        }

        binding.buttonSquare.setOnClickListener {
            val number = binding.editText.text.toString().toDouble()
            binding.editText.setText((sqrt(number)).toString())
        }
    }

    private fun onOperatorClick(operator: String) {
        if (!isNewOperation) {
            val currentText = binding.editText.text.toString()
            operand1 = currentText.toDouble()
            currentOperator = operator
            isNewOperation = true
        }
    }

    private fun setEqualsClickListener() {
        binding.buttonEquals.setOnClickListener {
            onEqualsClick()
        }
    }

    private fun onEqualsClick() {
        if (!isNewOperation) {
            val currentText = binding.editText.text.toString()
            val operand2 = currentText.toDouble()
            var result = 0.0

            when (currentOperator) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                "/" -> {
                    if (operand2 != 0.0) {
                        result = operand1 / operand2
                    } else {
                        binding.editText.setText("Error")
                        isNewOperation = true
                        return
                    }
                }
            }

            binding.editText.setText(result.toString())
            isNewOperation = true
        }
    }
}
