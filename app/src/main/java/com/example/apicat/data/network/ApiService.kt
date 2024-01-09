package com.example.catapi.network

import com.example.apicat.data.Models.ListadoVotos
import com.example.apicat.data.Models.Voto
import com.example.apicat.data.Models.respuesta_delete
import com.example.apicat.data.Models.respuesta_post
import com.example.catapi.Models.CatDataItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //conseguir listado de razas
    @Headers("x-api-key: live_7ounSIOi2tN9aH27ZN7PFKU5FbdZAzc5J4e5CXilYAEI5nLEiFlPknS0fKwYql0k")
    @GET("breeds")
    suspend fun Mostrar_razas(): Response<List<CatDataItem>>

    //publicar voto
    @Headers("x-api-key: live_7ounSIOi2tN9aH27ZN7PFKU5FbdZAzc5J4e5CXilYAEI5nLEiFlPknS0fKwYql0k",
            "Content-Type: application/json ")
    @POST("votes")
    suspend fun Agregar_voto(
        @Body voto: Voto
    ): Response<respuesta_post>

    //conseguir listado de votos
    @Headers("x-api-key: live_7ounSIOi2tN9aH27ZN7PFKU5FbdZAzc5J4e5CXilYAEI5nLEiFlPknS0fKwYql0k",
            "Content-Type: application/json ")
    @GET("votes")
    suspend fun Conseguir_voto(
        @Query("sub_id") id_img : String
    ): Response<List<ListadoVotos>>

    //eliminar voto
    @Headers("x-api-key: live_7ounSIOi2tN9aH27ZN7PFKU5FbdZAzc5J4e5CXilYAEI5nLEiFlPknS0fKwYql0k",
        "Content-Type: application/json ")
    @DELETE("votes/{id_voto}")
    suspend fun BorrarVoto(
        @Path("id_voto") votoid : Int?
    ): Response<respuesta_delete>
}