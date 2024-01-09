package com.example.apicat.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apicat.MainActivity
import com.example.apicat.ui.MyViewModel
import com.example.apicat.databinding.FragmentStatsBinding

class FragmentStats : Fragment() {

    private lateinit var binding: FragmentStatsBinding
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.gato_seleccionado.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name
            binding.adaptability.text = it.adaptability.toString()
            binding.affectionLevel.text = it.affectionLevel.toString()
            binding.childFriendly.text = it.childFriendly.toString()
            binding.dogFriendly.text = it.dogFriendly.toString()
            binding.grooming.text = it.grooming.toString()
            binding.healthIssues.text = it.healthIssues.toString()
            binding.intelligence.text = it.intelligence.toString()
            binding.lap.text = it.lap.toString()
            binding.indoor.text = it.indoor.toString()
        }
    }

}