package com.fiap.antoniorm80282

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhe.*

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val bundle = intent.extras
        val id = bundle?.getInt("id")
        val nome = bundle?.getString("name")
        val peso = bundle?.getInt("peso")
        val altura = bundle?.getInt("altura")
        val corOlho = bundle?.getString("corOlho")
        val corCabelo = bundle?.getString("corCabelo")

        tvID.text = id.toString()
        tvNome.text = nome.toString()
        tvPeso.text = peso.toString()
        tvAltura.text = altura.toString()
        tvOlho.text = corOlho
        tvCabelo.text = corCabelo

        btVoltar.setOnClickListener {
            Voltar()
        }
    }

    fun Voltar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
