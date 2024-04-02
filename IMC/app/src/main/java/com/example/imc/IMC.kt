package com.example.imc

import android.os.Parcel
import android.os.Parcelable
import kotlin.math.pow

class IMC(var nome: String?, var peso: Float, var altura: Float, var imc: Float) : Parcelable {

    init {
        calcularIMC() // Calcula o IMC quando o objeto é criado
    }

    private fun calcularIMC() {
        imc = if (altura != 0.0f) peso / (altura / 100).pow(2) else 0.0f
    }

    fun calcular(): String {
        val calc = imc
        return when {
            calc < 16 -> "Magreza grave"
            calc < 17 -> "Magreza moderada"
            calc < 18.5 -> "Magreza leve"
            calc < 25 -> "Saudável"
            calc < 30 -> "Sobrepeso"
            calc < 35 -> "Obesidade Grau I"
            calc < 40 -> "Obesidade Grau II"
            else -> "Obesidade Grau III"
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeFloat(peso)
        parcel.writeFloat(altura)
        parcel.writeFloat(imc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IMC> {
        override fun createFromParcel(parcel: Parcel): IMC {
            return IMC(parcel)
        }

        override fun newArray(size: Int): Array<IMC?> {
            return arrayOfNulls(size)
        }
    }
}