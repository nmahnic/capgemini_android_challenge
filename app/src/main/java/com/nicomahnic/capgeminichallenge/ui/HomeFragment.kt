package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentHomeBinding
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.ui.adapter.CharacterAdapter
import com.nicomahnic.capgeminichallenge.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by sharedViewModel<HomeViewModel>()

    private lateinit var adapter: CharacterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        adapter  = CharacterAdapter(onItemSelected)
        binding.rvCharacters.adapter = adapter

        lifecycleScope.launch{
            viewModel.state.collectLatest { state ->
                Log.e("NM", "STATE -> ${state}")
                state.data?.let { characters ->
                    Log.e("NM", "SPINNER -> ${state.spinner} ${state.data}")
                    binding.progress.visibility = if (state.spinner) View.VISIBLE else View.GONE
                    adapter.submitData(characters)
                }
            }
        }

    }

    private val onItemSelected = object :  CharacterAdapter.ItemListener {
        override fun onBtnClick(character: MarvelItem) {
            Log.d("NM", "character -> $character")
            val action = HomeFragmentDirections.actionHomeFragmentToDescriptionFragment(character)
            findNavController().navigate(action)
        }
    }

}