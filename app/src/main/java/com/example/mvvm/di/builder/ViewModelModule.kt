package com.example.mvvm.di.builder

import com.example.mvvm.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModels = module {
    viewModel {
        MainViewModel(get(), get())
    }

}