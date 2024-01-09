package com.example.apicat.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.apicat.data.Models.Voto
import com.example.apicat.ui.MyViewModel
import com.example.apicat.ui.adapters.AdapterTabs
import com.example.apicat.databinding.FragmentGatoBinding
import com.google.android.material.tabs.TabLayoutMediator


class FragmentGato : Fragment() {

    private val myViewModel by activityViewModels<MyViewModel>()
    private lateinit var binding: FragmentGatoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGatoBinding.inflate(inflater, container, false)
        return binding.root }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter_tabs = AdapterTabs(requireActivity())
        binding.viewpager.adapter = adapter_tabs

        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = if (position == 0) "Información" else "Stats"
        }.attach()




        myViewModel.gato_seleccionado.observe(viewLifecycleOwner){

            //pasar data
            Glide.with(this)
                .load("https://cdn2.thecatapi.com/images/${it.referenceImageId}.jpg")
                .into(binding.imgFondoGato)


            binding.fabUpload.setOnClickListener { _ ->
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(it.wikipediaUrl)
                }
                startActivity(intent)
            }

            //enviar voto como like
            binding.fabLike.setOnClickListener { _ ->

                val voto = it.referenceImageId?.let { it1 ->
                    Voto(
                        it1,
                        "asds",
                        1
                    )
                }
                if (voto != null) {
                    myViewModel.postVoto(voto)

                    Toast.makeText(requireContext() , "Voto enviado como like", Toast.LENGTH_SHORT).show()
                }
            }

            //enviar voto como dislike
            binding.fabDislike.setOnClickListener { _ ->
                val voto = it.referenceImageId?.let { it2 ->
                    Voto(
                        it2,
                        "asds",
                        2
                    )
                }
                if (voto != null) {
                    myViewModel.postVoto(voto)
                       Toast.makeText(requireContext(), "Voto enviado como dislike", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}