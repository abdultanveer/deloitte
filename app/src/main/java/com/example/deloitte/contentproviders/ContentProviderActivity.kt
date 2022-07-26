package com.example.deloitte.contentproviders

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.deloitte.R

class ContentProviderActivity : AppCompatActivity() {
    lateinit var cpListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        cpListView = findViewById(R.id.cpListview)
        val tableNameUri: Uri = Uri.parse("content://sms/inbox")

       var dataCursor: Cursor? = contentResolver.query(tableNameUri,null,null,null,null)

        var fromColNames = arrayOf("body","address")
        var toTextviewIds = intArrayOf(android.R.id.text1,android.R.id.text2)

        var myAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,
            dataCursor,
            fromColNames,
            toTextviewIds)
        cpListView.adapter = myAdapter
    }
}