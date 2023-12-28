package com.example.labs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.labs.Application

@Dao
interface ApplicationDao {
    @Insert
    suspend fun insert(television: Application)

    @Query("SELECT * FROM tv_table")
    suspend fun getAllTelevisions(): List<Application>

    @Update
    suspend fun update(television: Application)

    @Delete
    suspend fun delete(television: Application)
}