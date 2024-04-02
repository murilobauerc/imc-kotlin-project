package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado2.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        val imc = intent.getParcelableExtra<IMC>("value")
        if (imc != null) {
            textViewClassificacao.text = imc.calcular()
            "${imc.nome}".also { textViewHeaderDensidadeCorporal.text = it }
            "Seu IMC: ${String.format("%.2f", imc.imc)}".also { textViewResultadoIMC.text = it }
            "Seu Peso: ${imc.peso}kg".also { textViewPeso.text = it }
            "Sua Altura: ${imc.altura}cm".also { textViewAltura.text = it }
        } else {
            finish()
        }
    }
}