package com.example.mvvm.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "items", primaryKeys = ["id"])
data class Item(
        @field: SerializedName("id") val id: Int,
        @field: SerializedName("name") val name: String,
        @field: SerializedName("full_name") val description: String,
        @field: SerializedName("url") val url: String
)
