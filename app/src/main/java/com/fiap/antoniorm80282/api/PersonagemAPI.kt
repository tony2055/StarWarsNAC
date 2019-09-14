package com.fiap.antoniorm80282.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonagemAPI {
    @GET("/api/people/{id}")
    fun buscarPersonagem(@Path("id") id:Int): Call<Personagem>
}