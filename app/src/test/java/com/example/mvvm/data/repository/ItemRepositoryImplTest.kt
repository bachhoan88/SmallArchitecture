package com.example.mvvm.data.repository

import com.example.mvvm.createItem
import com.example.mvvm.data.remote.api.ItemApi
import com.example.mvvm.data.remote.response.SearchRepoResponse
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers.anyInt
import org.mockito.Matchers.anyString
import org.mockito.Mockito.`when` as whenever
import org.mockito.Mockito.mock
import java.util.*

class ItemRepositoryImplTest {
    private lateinit var itemRepositoryImpl: ItemRepositoryImpl
    private val itemApi = mock(ItemApi::class.java)

    @Before
    fun setup() {
        itemRepositoryImpl = ItemRepositoryImpl(itemApi)
    }

    @Test
    fun searchComplete() {
        val query = anyString()
        val page = anyInt()

        val searchRepoResponse = SearchRepoResponse(total = 1, items = Arrays.asList(createItem()))
        whenever(itemApi.searchRepos(query, page)).thenReturn(Single.just(searchRepoResponse))
        itemRepositoryImpl.searchItems(query, page).test().assertComplete()
    }

    @Test
    fun searchItems() {
        val query = anyString()
        val page = anyInt()

        val searchRepoResponse = SearchRepoResponse(total = 1, items = Arrays.asList(createItem()))
        whenever(itemApi.searchRepos(query, page)).thenReturn(Single.just(searchRepoResponse))

        val test = itemRepositoryImpl.searchItems(query, page).test()
        test.assertValue { items ->
            items == searchRepoResponse.items
        }
    }

    @Test
    fun searchReturnNull() {
        val query = anyString()
        val page = anyInt()
        whenever(itemApi.searchRepos(query, page)).thenReturn(Single.error(Throwable("error")))

        val test = itemRepositoryImpl.searchItems(query, page).test()
        test.assertError {
            true
        }
    }
}