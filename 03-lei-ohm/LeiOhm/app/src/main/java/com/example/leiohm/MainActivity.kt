package com.example.leiohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTensao: EditText = findViewById(R.id.editTensao)
        val editResistencia: EditText = findViewById(R.id.editResistencia)
        val editCorrente: EditText = findViewById(R.id.editCorrente)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val textResultado: TextView = findViewById(R.id.textResultado)

        btnCalcular.setOnClickListener {

            val tensaoPreenchida = editTensao.text.isNotEmpty()
            val resistenciaPreenchida = editResistencia.text.isNotEmpty()
            val correntePreenchida = editCorrente.text.isNotEmpty()
            var camposPreenchidos = 0
            if (tensaoPreenchida) camposPreenchidos++
            if (resistenciaPreenchida) camposPreenchidos++
            if (correntePreenchida) camposPreenchidos++

            if (camposPreenchidos != 2) {
                Toast.makeText(this, "Preencha exatamente dois campos para calcular", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            when {
                tensaoPreenchida && resistenciaPreenchida -> {
                    val v = editTensao.text.toString().toDouble()
                    val r = editResistencia.text.toString().toDouble()

                    if (r == 0.0) {
                        Toast.makeText(this, "Resistência não pode ser zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    val i = v / r
                    textResultado.text = "Corrente (I) = $i A"
                }

                tensaoPreenchida && correntePreenchida -> {
                    val v = editTensao.text.toString().toDouble()
                    val i = editCorrente.text.toString().toDouble()

                    if (i == 0.0) {
                        Toast.makeText(this, "Corrente não pode ser zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                    val r = v / i
                    textResultado.text = "Resistência (R) = $r Ω"
                }
                resistenciaPreenchida && correntePreenchida -> {
                    val r = editResistencia.text.toString().toDouble()
                    val i = editCorrente.text.toString().toDouble()
                    val v = r * i
                    textResultado.text = "Tensão (V) = $v V"
                }
            }
        }
    }
}
