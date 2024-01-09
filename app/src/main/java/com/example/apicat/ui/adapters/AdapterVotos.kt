package com.example.apicat.ui.adapters

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apicat.data.Models.ListadoVotos
import com.example.apicat.ui.MyViewModel
import com.example.apicat.R
import com.example.apicat.databinding.CeldaVotosBinding
import java.util.Calendar

class AdapterVotos(private val myViewModel: MyViewModel) : RecyclerView.Adapter<AdapterVotos.CeldaDeVotos>() {

    private var votos = ArrayList<ListadoVotos>()

    inner class CeldaDeVotos(val binding: CeldaVotosBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaDeVotos {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaVotosBinding.inflate(layoutInflater, parent, false)
        return CeldaDeVotos(binding)
    }


    override fun onBindViewHolder(holder: CeldaDeVotos, position: Int) {
        val votos_realizados : ListadoVotos = votos.get(position)
        //pasar datos
        with(holder.binding){
            Glide.with(holder
                .itemView.context)
                .load("https://cdn2.thecatapi.com/images/${votos_realizados.image?.id}.jpg")
                .into(holder.binding.imgGatoVotado)

            // obtener la fecha actual
/*
            val fecha = votos_realizados.createdAt
            val formatoOrigen = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val date = formatoOrigen.parse(fecha)
            val calendar = Calendar.getInstance()
            calendar.time = date
            val df = SimpleDateFormat("dd/MM/yyyy")
            val fechaFinal = df.format(calendar.time)

            holder.binding.tvFecha.text = fechaFinal

*/




            holder.binding.imgRemoveVoto.setOnClickListener {
                val votoid = votos_realizados.id
               myViewModel.deleteVoto(votoid)
            }
        }

        when(votos_realizados.value) {
            1 -> holder.binding.imgLikeVoto.setImageResource(R.drawable.like)
            else -> holder.binding.imgLikeVoto.setImageResource(R.drawable.dislike)
        }

    }


    override fun getItemCount(): Int {
      return votos.size
    }

    fun updateList(lista: List<ListadoVotos>) {
        votos.clear()
        votos.addAll(lista)
        notifyDataSetChanged()
    }

}