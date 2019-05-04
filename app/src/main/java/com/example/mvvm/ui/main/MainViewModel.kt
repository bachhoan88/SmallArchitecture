package com.example.mvvm.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.mvvm.base.BaseViewModel
import com.example.mvvm.data.ItemRepository
import com.example.mvvm.data.model.Item
import com.example.mvvm.rx.SchedulerProvider

class MainViewModel (
        private val itemRepository: ItemRepository,
        private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {

    val data = MutableLiveData<List<Item>>()
    val query = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

    fun searchRepo() {
        query.value?.let { input ->
            if (input.isNotBlank()) {
                loading.value = true

                compositeDisposable.add(itemRepository.searchItems(query = input, page = 1)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .doFinally { loading.value = false }
                        .subscribe({ items ->
                            data.value = items
                        }, {})
                )
            }
        }
    }

}
