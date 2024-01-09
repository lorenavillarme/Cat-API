package com.example.apicat.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.apicat.databinding.CeldaListadoBinding
import com.example.catapi.Models.CatDataItem


class AdapterListado(
    val listener: OnItemClickListener
) : RecyclerView.Adapter<AdapterListado.MiCelda>(), Filterable {

    private var gatos = ArrayList<CatDataItem>()
    private var listaCopia = ArrayList<CatDataItem>()

    interface OnItemClickListener {
        fun onItemClick(dataItem: CatDataItem)
    }

    inner class MiCelda(val binding: CeldaListadoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaListadoBinding.inflate(layoutInflater, parent, false)
        return MiCelda(binding)
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {

        val dataItem: CatDataItem = gatos.get(position)
        holder.binding.tvRaza.text = dataItem.name
        holder.binding.tvPais.text = dataItem.origin

        holder.itemView.setOnClickListener {
            listener.onItemClick((dataItem)) //otra manera
        }

    }

    override fun getItemCount(): Int {
        return gatos.size
    }

    fun updateList(lista: List<CatDataItem>) {
        gatos.clear()
        gatos.addAll(lista)
        //copia
        listaCopia.clear()
        listaCopia.addAll(lista)
        notifyDataSetChanged()
    }

    //filtrado de búsqueda
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                //lógica de búsqueda
                val filteredList = if (busqueda.isEmpty()) {
                  listaCopia
                } else {
                    listaCopia.filter {
                        it.name?.lowercase()?.contains(busqueda) ?: false || //minus
                                it.name?.uppercase()?.contains(busqueda) ?: false //mayus

                    }
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                gatos = results?.values as ArrayList<CatDataItem>
                notifyDataSetChanged()
            }

        }
    }

}