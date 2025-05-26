package com.example.week12.viewmodel

import com.example.week12.roomDB.ItemDatabase
import com.example.week12.roomDB.ItemEntity

class ItemRepository(private val db: ItemDatabase) {
    val dao = db.getItemDAO()

    suspend fun insertItem(item: ItemEntity) {
        dao.InsertItem(item)
    }

    suspend fun updateItem(item: ItemEntity) {
        dao.UpdateItem(item)
    }

    suspend fun deleteItem(item: ItemEntity) {
        dao.DeleteItem(item)
    }

    fun getAllItems() = dao.getAllItems()
}