package com.fiap.antoniorm80282.api

import com.google.gson.annotations.SerializedName

data class Personagem (
    @SerializedName("id") val ID:Int,
    @SerializedName("name") val nome:String,
    @SerializedName("height") val altura:Int,
    @SerializedName("mass") val massa:Int,
    @SerializedName("hair_color") val cabelo:String,
    @SerializedName("eye_color") val olho:String
)