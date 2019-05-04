package com.example.mvvm.data.remote.response

import com.example.mvvm.data.model.Item
import com.google.gson.annotations.SerializedName

data class SearchRepoResponse(
        @SerializedName("total_count") val total: Int = 0,
        @SerializedName("items") val items: List<Item>
)
