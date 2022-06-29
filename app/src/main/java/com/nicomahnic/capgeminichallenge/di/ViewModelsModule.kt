package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelsModule{

	val modules = module {
		viewModel { HomeViewModel( get() ) }
	}

}
