package com.example.guiapocket_ygor.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.guiapocket_ygor.data.dao.ComercioDao
import com.example.guiapocket_ygor.model.Comercio

@Database(entities = [Comercio::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comercioDao(): ComercioDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "guia_pocket_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}