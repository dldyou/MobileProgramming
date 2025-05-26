package com.example.week12.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun getItemDAO(): ItemDAO

    companion object {
        @Volatile
        private var DBInstance: ItemDatabase? = null

        fun getDBInstance(context: Context): ItemDatabase {
            return DBInstance ?: synchronized(this) {
                val instance = DBInstance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "itemdb"
                ).build()
                DBInstance = instance
                instance
            }
        }
    }
}