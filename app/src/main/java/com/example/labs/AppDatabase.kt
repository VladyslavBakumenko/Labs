package com.example.labs

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Application::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun televisionDao(): ApplicationDao
}