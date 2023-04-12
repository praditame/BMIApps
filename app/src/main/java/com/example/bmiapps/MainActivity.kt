package com.example.bmiapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import java.security.interfaces.EdECKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightEd = findViewById<EditText>(R.id.numberWeight)
        val heightEd = findViewById<EditText>(R.id.numberHeight)
        val btnCalc = findViewById<Button>(R.id.btnCalculate)

        btnCalc.setOnClickListener {
            val w = weightEd.text.toString()
            val h = heightEd.text.toString()
            when {
                w.isNullOrEmpty()->{
                    Toast.makeText(this, "Isi berat anda", Toast.LENGTH_LONG).show()
                }
                h.isNullOrEmpty()->{
                    Toast.makeText(this, "Isi tinggi anda", Toast.LENGTH_LONG).show()
                }
                else ->{
                    val bmi = w.toFloat()/((h.toFloat()/100)*(h.toFloat()/100))
                    result(bmi)
                }
            }
        }
    }



    private fun result(bmi:Float){
        val res = findViewById<TextView>(R.id.result)
        val des = findViewById<TextView>(R.id.status);
        res.text = bmi.toString()

        when{
            bmi < 18.50 -> {
                des.text = "Underweight"
            }
            bmi in 18.50..24.99-> {
                des.text = "Healthy"
            }
            bmi in 25.00..29.99->{
                des.text = "Overweight"
            }
            bmi > 29.99->{
                des.text = "Obese"
            }
        }

    }
}