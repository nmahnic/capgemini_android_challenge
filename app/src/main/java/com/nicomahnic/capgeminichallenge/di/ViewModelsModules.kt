package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.ui.viewmodels.DescriptionViewModel
import com.nicomahnic.capgeminichallenge.ui.viewmodels.FavouriteViewModel
import com.nicomahnic.capgeminichallenge.ui.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelsModules{

	val homeViewModel = module {
		viewModel { HomeViewModel( get() ) }
	}

	val descriptionViewModel = module {
		viewModel { DescriptionViewModel( get(), get(), get() ) }
	}

	val favouriteViewModel = module {
		viewModel { FavouriteViewModel( get() ) }
	}

}
