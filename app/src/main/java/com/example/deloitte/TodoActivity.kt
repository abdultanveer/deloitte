package com.example.deloitte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import com.example.deloitte.database.DbAccessObject
import com.example.deloitte.database.FeedReaderContract
import com.example.deloitte.database.Note
import com.example.deloitte.database.FeedReaderContract.FeedEntry;


class TodoActivity : AppCompatActivity() {
    lateinit var etTitle:EditText
    lateinit var etSubtitle: EditText
    lateinit var dbAccessObject: DbAccessObject

    lateinit var tvDbResult:TextView
    lateinit var lvDatabase:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        etTitle = findViewById(R.id.etTitle)
        etSubtitle = findViewById(R.id.etSubtitle)
        tvDbResult = findViewById(R.id.tvDbResult)
        lvDatabase = findViewById(R.id.lvDb)
        dbAccessObject = DbAccessObject(this)
        dbAccessObject.openDb()
    }

    override fun onStart() {
        super.onStart()
        var fromColNames = arrayOf(FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE)
        var toTextviewIds = intArrayOf(android.R.id.text1,android.R.id.text2)
        var cursor = dbAccessObject.getAllRows()
        var myAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2, //row layout
         cursor,
            fromColNames, toTextviewIds,0)
        lvDatabase.adapter = myAdapter
    }

    fun dbHandler(view: View) {
        when(view.id){
            R.id.btnCommit ->{  putDataDb()}
            R.id.btnRetreive ->{getDataDb()}
        }

    }

    private fun getDataDb() {
        var result:String = dbAccessObject.readRow()
        tvDbResult.text = result
    }

    private fun putDataDb() {
        //get the data from the edittext
        var title = etTitle.text.toString()
        var subTitle = etSubtitle.text.toString()
        var note = Note(title, subTitle);
        dbAccessObject.createRow(note)
        //dbAccessObject.createRow(title,subTitle)

    }
}