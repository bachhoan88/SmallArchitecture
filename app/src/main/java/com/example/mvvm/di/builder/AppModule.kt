package com.example.mvvm.di.builder

import com.example.mvvm.di.data.networkModules
import com.example.mvvm.di.data.repositoryModules
import com.example.mvvm.rx.AppSchedulerProvider
import com.example.mvvm.rx.SchedulerProvider
import org.koin.dsl.module.module

val schedulers = module {
    single { AppSchedulerProvider() as SchedulerProvider }
}

val modules = listOf(viewModels, schedulers, networkModules, repositoryModules)