package com.example.appcalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editNum1: EditText
    private lateinit var editNum2: EditText
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNum1 = findViewById(R.id.editNum1)
        editNum2 = findViewById(R.id.editNum2)
        textResultado = findViewById(R.id.textResultado)

        val btnSomar: Button = findViewById(R.id.btnSomar)
        val btnSubtrair: Button = findViewById(R.id.btnSubtrair)
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicar)
        val btnDividir: Button = findViewById(R.id.btnDividir)

        btnSomar.setOnClickListener {
            calcular("+")
        }

        btnSubtrair.setOnClickListener {
            calcular("-")
        }

        btnMultiplicar.setOnClickListener {
            calcular("x")
        }

        btnDividir.setOnClickListener {
            calcular("÷")
        }
    }
    private fun calcular(operacao: String) {
        if (editNum1.text.isEmpty() || editNum2.text.isEmpty()) {
            Toast.makeText(this, "Preencha os dois números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = editNum1.text.toString().toDouble()
        val num2 = editNum2.text.toString().toDouble()

        val resultado: Double

        when (operacao) {
            "+" -> resultado = num1 + num2
            "-" -> resultado = num1 - num2
            "x" -> resultado = num1 * num2
            "÷" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show()
                    return
                }
                resultado = num1 / num2
            }
            else -> resultado = 0.0
        }
        textResultado.text = "Resultado: $resultado"
    }
}
