package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.capgeminichallenge.viewmodels.HomeViewModel
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentHomeBinding
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter
import com.nicomahnic.capgeminichallenge.ui.adapter.CharacterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()

    private lateinit var adapter: CharacterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        adapter  = CharacterAdapter(onItemSelected)
        binding.rvCharacters.adapter = adapter

        binding.btnFetch.setOnClickListener {
            lifecycleScope.launch {
                viewModel.items.collectLatest {
                    adapter.submitData(it)
                }
            }
        }

    }

    private val onItemSelected = object :  CharacterAdapter.ItemListener {
        override fun onBtnClick(character: MarvelCharacter) {
            Log.e("NM", "character -> $character")
            val action = HomeFragmentDirections.actionHomeFragmentToDescriptionFragment()
            findNavController().navigate(action)
        }
    }

}