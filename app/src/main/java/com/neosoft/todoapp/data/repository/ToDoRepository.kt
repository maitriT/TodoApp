package com.neosoft.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.neosoft.todoapp.data.ToDoDao
import com.neosoft.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

     fun insertData(toDoData: ToDoData) = toDoDao.insertData(toDoData)

     fun updateData(toDoData: ToDoData) = toDoDao.updateData(toDoData)

     fun deleteItem(toDoData: ToDoData) = toDoDao.deleteItem(toDoData)

     fun deleteAll() = toDoDao.deleteAll()

    fun searchDatabase(searchQuery: String) = toDoDao.searchDatabase(searchQuery)

    fun sortByHighPriority() = toDoDao.sortByHighPriority()

    fun sortByLowPriority() = toDoDao.sortByLowPriority()
}