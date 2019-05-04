package com.example.mvvm.data.local.db

import androidx.room.Room
import org.junit.After
import org.junit.Before
import org.robolectric.RuntimeEnvironment

abstract class DbTest {
    private lateinit var appDatabase: AppDatabase
    val db: AppDatabase
        get() = appDatabase

    @Before
    fun setup() {
        appDatabase = Room.inMemoryDatabaseBuilder(RuntimeEnvironment.application, AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun close() {
        appDatabase.close()
    }
}