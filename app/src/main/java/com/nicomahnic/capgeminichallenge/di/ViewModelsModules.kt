package com.nicomahnic.capgeminichallenge.di

import com.nicomahnic.capgeminichallenge.viewmodels.DescriptionViewModel
import com.nicomahnic.capgeminichallenge.viewmodels.FavouriteViewModel
import com.nicomahnic.capgeminichallenge.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelsModules{

	val homeViewModel = module {
		viewModel { HomeViewModel( get() ) }
	}

	val descriptionViewModel = module {
		viewModel { DescriptionViewModel( get() ) }
	}

	val favouriteViewModel = module {
		viewModel { FavouriteViewModel( get() ) }
	}

}
