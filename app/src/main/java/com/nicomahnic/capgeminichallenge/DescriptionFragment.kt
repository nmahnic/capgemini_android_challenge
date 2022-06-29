package com.nicomahnic.capgeminichallenge


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nicomahnic.capgeminichallenge.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private lateinit var binding: FragmentDescriptionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDescriptionBinding.bind(view)

    }
}