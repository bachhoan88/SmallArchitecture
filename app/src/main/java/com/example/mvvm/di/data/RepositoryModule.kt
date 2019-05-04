package com.example.mvvm.di.data

import android.content.Context
import com.example.mvvm.data.ItemRepository
import com.example.mvvm.data.local.pref.AppPrefs
import com.example.mvvm.data.local.pref.PrefHelper
import com.example.mvvm.data.remote.api.ItemApi
import com.example.mvvm.data.repository.ItemRepositoryImpl
import org.koin.dsl.module.module

fun createPrefHelper(context: Context): PrefHelper = AppPrefs(context)

fun createItemRepository(itemApi: ItemApi): ItemRepository = ItemRepositoryImpl(itemApi)

val repositoryModules = module {
    single { createPrefHelper(get()) }

    single { createItemRepository(get()) }
}
