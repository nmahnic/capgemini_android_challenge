package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentHomeBinding
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.ui.adapter.items.ItemsAdapter
import com.nicomahnic.capgeminichallenge.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by sharedViewModel<HomeViewModel>()

    private lateinit var adapter: ItemsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        adapter  = ItemsAdapter(onItemSelected)
        binding.rvCharacters.adapter = adapter


        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                state.data?.let { characters ->
                    binding.rvLoading.visibility = if (state.spinner) View.VISIBLE else View.GONE
                    adapter.submitData(characters)
                }
            }
        }

        adapter.addLoadStateListener {
            Log.d("NM", "addLoadStateListener -> $it")
            when(it.source.refresh){
                is LoadState.Error -> {}
                is LoadState.NotLoading -> { viewModel.notLoading( viewModel.state.value.copy(spinner = false) ) }
                is LoadState.Loading -> {}
            }
        }

    }

    private val onItemSelected = object :  ItemsAdapter.ItemListener {
        override fun onBtnClick(character: MarvelItem) {
            val action = HomeFragmentDirections.actionHomeFragmentToDescriptionFragment(character)
            findNavController().navigate(action)
        }
    }

}