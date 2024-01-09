package com.example.apicat.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apicat.data.Models.ListadoVotos
import com.example.apicat.data.Models.Voto
import com.example.apicat.data.Models.respuesta_post
import com.example.apicat.data.Repositorio
import com.example.catapi.Models.CatDataItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val context: Context) : ViewModel() {

    private val repositorio = Repositorio(context)

    //declarar LiveDatas
    val listado_gatos = MutableLiveData<List<CatDataItem>?>()
    val gato_seleccionado = MutableLiveData<CatDataItem>()

    val listado_votos = MutableLiveData<List<ListadoVotos>?>()
    val voto_agregado = MutableLiveData<respuesta_post?>()



    fun getRazas(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getRazas()
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                listado_gatos.postValue(miRespuesta)
            }
        }

    }

    fun postVoto(voto: Voto) {  //pasar voto
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.postVoto(voto)
            if (response.isSuccessful) {
                val miRespuesta_agregarVoto = response.body()
                voto_agregado.postValue(miRespuesta_agregarVoto)
            }
        }
    }

    fun getVoto(id_img: String){    //pasar id
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getVoto(id_img)
            if (response.isSuccessful) {
                val miRespuesta_voto = response.body()
                listado_votos.postValue(miRespuesta_voto)
            }
        }

    }

    fun deleteVoto(votoid: Int?){    //pasar id a eliminar
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.deleteVoto(votoid)
            if (response.isSuccessful)
                getVoto("asds")

        }

    }



    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}