package com.example.hiddencalculatorhw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTV: TextView
    private lateinit var calculatorBTN: Button

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode == RESULT_OK){
            val data = result.data
            val res = data!!.getStringExtra("result")
            resultTV.text = res
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        init()
        calculatorBTN.setOnClickListener{
            val intent = Intent(this,CalculatorActivitySecond::class.java)
            launchSomeActivity.launch(intent)
        }

    }

    private fun init(){
        setContentView(R.layout.activity_main)
        resultTV = findViewById(R.id.resultTV)
        calculatorBTN = findViewById(R.id.calculatorBTN)
    }
}