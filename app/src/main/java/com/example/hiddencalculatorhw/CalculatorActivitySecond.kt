package com.example.hiddencalculatorhw

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivitySecond : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var buttonMultBTN: Button
    private lateinit var buttonDivBTN: Button
    private lateinit var buttonTransferDataBTN: Button

    private var result = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        init()
        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
        buttonMultBTN.setOnClickListener(this)
        buttonDivBTN.setOnClickListener(this)

        buttonTransferDataBTN.setOnClickListener{
            val intent = Intent()
            intent.putExtra("result", result.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }


    private fun init() {
        setContentView(R.layout.activity_calculator_second)
        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)

        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonMultBTN = findViewById(R.id.buttonMultBTN)
        buttonDivBTN = findViewById(R.id.buttonDivBTN)
        buttonTransferDataBTN = findViewById(R.id.buttonTransferDataBTN)
    }

    override fun onClick(v: View) {

        if(firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) return

        val first = firstOperandET.text.toString().toDouble()
        val second = secondOperandET.text.toString().toDouble()

        result = when(v.id){
            R.id.buttonSumBTN -> Operator(first, second).sum()
            R.id.buttonDifBTN -> Operator(first, second).dif()
            R.id.buttonMultBTN -> Operator(first, second).mult()
            R.id.buttonDivBTN -> Operator(first, second).div()

            else -> 0.0
        }

    }
}