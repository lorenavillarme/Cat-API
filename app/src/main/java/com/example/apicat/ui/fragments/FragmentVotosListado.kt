package com.example.apicat.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apicat.ui.MyViewModel
import com.example.apicat.ui.adapters.AdapterVotos
import com.example.apicat.databinding.FragmentListadoBinding


class FragmentVotosListado : Fragment() {
    private var _binding: FragmentListadoBinding? = null
    private val binding get() = _binding!!


    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = LinearLayoutManager(context)


        val votosAdapter = AdapterVotos(myViewModel)
        binding.recyclerview.adapter = votosAdapter

        //observe
        myViewModel.listado_votos.observe(viewLifecycleOwner) {
            if (it != null)
                votosAdapter.updateList(it)

        }


        myViewModel.getVoto("asds")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}