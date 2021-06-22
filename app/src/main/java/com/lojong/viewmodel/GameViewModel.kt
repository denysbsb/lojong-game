package com.lojong.viewmodel

import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.flow.Flow

class GameViewModel(private val itemDao: ItemDao) : ViewModel() {

    fun setState(){}
    fun getState(){}

    private suspend fun insertItem(item: Item) {
        itemDao.insert(item)
    }

    private fun getItem(item: Item): Flow<Item> {
        return itemDao.getItem(item.id)
    }

    private suspend fun updateItem(item: Item) {
         itemDao.update(item)
    }
}