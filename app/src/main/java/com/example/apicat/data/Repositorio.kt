package com.example.apicat.data

import android.content.Context
import com.example.apicat.data.Models.Voto
import com.example.catapi.network.RetrofitHelper

class Repositorio(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getRazas() = retrofit.Mostrar_razas()
    suspend fun postVoto(rate: Voto) = retrofit.Agregar_voto(rate) //pasar var de voto
    suspend fun  getVoto(id_img : String) = retrofit.Conseguir_voto(id_img) //pasar
    suspend fun deleteVoto(votoid: Int?) = retrofit.BorrarVoto(votoid)   //pasar int como voto a eliminar

}