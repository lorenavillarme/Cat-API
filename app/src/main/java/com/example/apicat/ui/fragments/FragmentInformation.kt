package com.example.apicat.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apicat.MainActivity
import com.example.apicat.ui.MyViewModel
import com.example.apicat.databinding.FragmentInformationBinding

class FragmentInformation : Fragment() {


    private lateinit var binding: FragmentInformationBinding
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root  }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.gato_seleccionado.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name

            binding.tvPeso.text = it.weight.toString()
            binding.tvTemperamento.text = it.temperament
            binding.tvOrigen.text = it.origin
            binding.tvEspearanzadevida.text = it.lifeSpan
            binding.tvDescripcion.text = it.description

        }
    }
}