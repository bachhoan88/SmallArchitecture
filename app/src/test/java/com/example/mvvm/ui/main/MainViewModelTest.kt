package com.example.mvvm.ui.main

import androidx.lifecycle.Observer
import com.example.mvvm.createItem
import com.example.mvvm.data.ItemRepository
import com.example.mvvm.data.model.Item
import com.example.mvvm.mock
import com.example.mvvm.rx.AppSchedulerProvider
import com.example.mvvm.ui.BaseViewModelTest
import io.reactivex.Single
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock

/**
 * Unit Test for [MainViewModel]
 */
class MainViewModelTest : BaseViewModelTest() {
    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var itemRepository: ItemRepository

    private val schedulerProvider = AppSchedulerProvider()

    override fun setup() {
        super.setup()
        mainViewModel = MainViewModel(itemRepository, schedulerProvider)
    }

    @Test
    fun searchNull() {
        mainViewModel.query.value = null
        mainViewModel.searchRepo()

        assertThat(mainViewModel.data.value, nullValue())
        assertEquals(mainViewModel.loading.value, false)
    }

    @Test
    fun testSearchUserId() {
        val query = "Bach"
        mainViewModel.query.value = query

        val item = createItem()
        val listItem: List<Item> = arrayListOf(item)
        given(itemRepository.searchItems(query)).willReturn(Single.just(listItem))

        val observer = mock<Observer<List<Item>>>()
        mainViewModel.data.observeForever(observer)

        mainViewModel.searchRepo()

        assertEquals(mainViewModel.data.value, listItem)

    }
}