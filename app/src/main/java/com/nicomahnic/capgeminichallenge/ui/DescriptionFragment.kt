package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentDescriptionBinding
import com.nicomahnic.capgeminichallenge.utils.Utils

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private lateinit var binding: FragmentDescriptionBinding

    private val args: DescriptionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDescriptionBinding.bind(view)

        binding.tvCharacterName.text = args.item.name
        binding.tvReleased.text = "${getString(R.string.modified)} ${Utils.parseModifiedDate(args.item.modified)}"

        val url = Utils.performUls(args.item)
        Glide.with(this).load(url).centerCrop().into(binding.imgBackgroud)

    }
}