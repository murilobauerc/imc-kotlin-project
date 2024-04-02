package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener {
            if (validarCamposBasicos()) {
                val name = editNome.text.toString()
                val peso = editPeso.text.toString().toFloatOrNull() ?: 0.0f
                val altura = editAltura.text.toString().toFloatOrNull() ?: 0.0f
                val imc = IMC(name, peso, altura, 0.0f) // IMC é calculado na inicialização da classe IMC
                val intent = Intent(this, ResultadoActivity::class.java).apply {
                    putExtra("value", imc)
                }
                startActivity(intent)
            }
        }
    }

    private fun validarCamposBasicos(): Boolean {
        if (editNome.text.isNullOrBlank()) {
            Toast.makeText(this, "Por favor, insira o nome.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (editPeso.text.isNullOrBlank()) {
            Toast.makeText(this, "Por favor, insira o peso.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (editAltura.text.isNullOrBlank()) {
            Toast.makeText(this, "Por favor, insira a altura.", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}