package com.example.mvvm.data.repository

import com.example.mvvm.data.ItemRepository
import com.example.mvvm.data.model.Item
import com.example.mvvm.data.remote.api.ItemApi
import io.reactivex.Single

class ItemRepositoryImpl(
        private val itemApi: ItemApi
) : ItemRepository {
    override fun searchItems(query: String, page: Int?): Single<List<Item>> {
        return itemApi.searchRepos(query = query, page = if (page == null) 0 else page)
                .map { response ->
                    response.items
                }
                .doOnError { Throwable("Not found!") }
    }

}