package com.example.deloitte.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.deloitte.database.FeedReaderContract.FeedEntry;


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

    fun createRow(note: Note) {
        var values = ContentValues()
        values.put(FeedEntry.COLUMN_NAME_TITLE,note.getTitle())
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,note.getSubTitle())

        database.insert(FeedEntry.TABLE_NAME,null,values)
    }
    fun readRow(): String {
       // database.rawQuery("select * from enty",null)
        //select * from entry
       var cursor: Cursor =  database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null,)
        //cursor is pointing to the result set
        cursor.moveToLast()
        var titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE)
        var title = cursor.getString(titleIndex)

        var subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE)
        var subtitle = cursor.getString(subtitleIndex)

        return title + "\n"+ subtitle
    }
    fun getAllRows(){}
    fun deleteRow(){}
}