package com.example.mvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.local.db.dao.ItemDao
import com.example.mvvm.data.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}