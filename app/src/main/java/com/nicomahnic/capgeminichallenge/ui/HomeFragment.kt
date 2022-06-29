package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nicomahnic.capgeminichallenge.viewmodels.HomeViewModel
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.btnFetch.setOnClickListener {
            viewModel.fetchCharacters()
            binding.tvTest.visibility = View.VISIBLE
        }

        binding.btnNavigate.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDescriptionFragment()
            findNavController().navigate(action)
        }

    }

}