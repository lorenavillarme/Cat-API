package com.example.apicat.ui.fragments



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.apicat.ui.adapters.AdapterListado
import com.example.apicat.ui.MyViewModel
import com.example.apicat.R
import com.example.apicat.databinding.FragmentListadoBinding
import com.example.catapi.Models.CatDataItem


class FragmentListado : Fragment() {

    private var _binding: FragmentListadoBinding? = null
    private lateinit var listAdapter: AdapterListado
    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //buscador por menu
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.mymenu, menu)

                val menuItem = menu.findItem(R.id.app_bar_search)
                val searchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        listAdapter.filter.filter(query)
                        return true
                    }


                    override fun onQueryTextChange(newText: String?): Boolean {
                        listAdapter.filter.filter(newText)
                        return true
                    }

                })

            }


            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }
        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)
        binding.swipe.setSize(SwipeRefreshLayout.LARGE)

        binding.swipe.setOnRefreshListener {
            myViewModel.getRazas()
        }


        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        //pasar a fragment de gato
         listAdapter = AdapterListado(
            object : AdapterListado.OnItemClickListener {

                override fun onItemClick(dataItem: CatDataItem) {
                    myViewModel.gato_seleccionado.value = dataItem
                    findNavController().navigate(R.id.action_fragmentListado2_to_fragmentGato)
                }

            }
        )


        //pasar a fragment de votos
        binding.butGoVotes.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentListado_to_fragmentVotosListado)
        }


        binding.recyclerview.adapter = listAdapter

        //observe
        myViewModel.listado_gatos.observe(viewLifecycleOwner) {
            binding.swipe.isRefreshing = false
            if (it != null)
                listAdapter.updateList(it)
        }

        myViewModel.getRazas()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}