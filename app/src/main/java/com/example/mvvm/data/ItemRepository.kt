package com.example.mvvm.data

import com.example.mvvm.base.Repository
import com.example.mvvm.data.model.Item
import io.reactivex.Single

interface ItemRepository : Repository {
    fun searchItems(query: String, page: Int? = 1): Single<List<Item>>
}