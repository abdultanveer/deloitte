package com.example.deloitte.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase

/**
 * this class will help the activity insert and retreive data from/to db
 */
class DbAccessObject(var context: Context) {
    lateinit var database : SQLiteDatabase
    lateinit var dbHelper: DbHelper

    fun openDb(){
        dbHelper = DbHelper(context)
        database = dbHelper.writableDatabase
    }
    fun closeDb(){}

    fun createRow(){}
    fun readRow(){}
    fun getAllRows(){}
    fun deleteRow(){}
}