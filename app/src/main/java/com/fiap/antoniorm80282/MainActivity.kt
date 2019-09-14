package com.fiap.antoniorm80282

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fiap.antoniorm80282.api.Personagem
import com.fiap.antoniorm80282.api.PersonagemAPI
import kotlinx.android.synthetic.main.activity_detalhe.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisar.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(PersonagemAPI::class.java)
            service.buscarPersonagem(etID.text.toString().toInt())
                .enqueue(object : Callback<Personagem>{
                    override fun onFailure(call: Call<Personagem>, t: Throwable) {
                        Toast.makeText(this@MainActivity,
                            "ERRO",
                            Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Personagem>, response: Response<Personagem>) {
                        if(response.isSuccessful){
                            val personagem = response?.body()

                            Pesquisar(personagem)
                        }
                        else{
                            Log.i("ERRO", "Erro ao carregar personagem")
                        }
                    }
                })
        }
    }

    fun Pesquisar(personagem: Personagem?){
        val intent = Intent(this, DetalheActivity::class.java)

        val id = personagem?.ID
        val name = personagem?.nome
        val peso = personagem?.massa
        val altura = personagem?.altura
        val corDoOlho = personagem?.olho
        val corDoCabelo = personagem?.cabelo
        intent.putExtra("name", name)
        intent.putExtra("id", id)
        intent.putExtra("peso", peso)
        intent.putExtra("altura", altura)
        intent.putExtra("corOlho", corDoOlho)
        intent.putExtra("corCabelo", corDoCabelo)

        startActivity(intent)
        finish()
    }
}
