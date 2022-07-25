package com.example.deloitte.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.deloitte.database.FeedReaderContract.FeedEntry;

/**
 * to help me create a db and a table
 */
class DbHelper(context: Context) : SQLiteOpenHelper(context,"deloite_db",null,1){

    //"create table entry(_id integer primary key, title text, subtitle text)"
    private  val SQL_CREATE_ENTRIES: String =
        "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${FeedEntry.COLUMN_NAME_TITLE} TEXT," +
                "${FeedEntry.COLUMN_NAME_SUBTITLE} TEXT)"

    //oncreate wiil be called when the db is getting created for the 1st time
    override fun onCreate(database: SQLiteDatabase?) {

    }

    //if you are migrating from version 1 to 2 -- suppose u wanna add/remove columns to the existing table
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}