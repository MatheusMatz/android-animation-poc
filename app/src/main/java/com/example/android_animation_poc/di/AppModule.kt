package com.example.android_animation_poc.di

import com.example.android_animation_poc.data.RetrofitConfig
import com.example.android_animation_poc.presentation.visibility.VisibilityAnimationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        RetrofitConfig.getInstance()
    }

    viewModel {
        VisibilityAnimationViewModel()
    }
}