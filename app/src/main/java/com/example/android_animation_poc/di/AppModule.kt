package com.example.android_animation_poc.di

import com.example.android_animation_poc.presentation.sample.cathome.HomeViewModel
import com.example.android_animation_poc.presentation.sample.catlist.ListViewModel
import com.example.android_animation_poc.presentation.sample.catprofile.ProfileViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        ListViewModel()
    }
    viewModel {
        HomeViewModel()
    }

    viewModel {
        ProfileViewModel()
    }
}