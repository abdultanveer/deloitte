package com.example.deloitte.contentproviders

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import com.example.deloitte.R

class ContentProviderActivity : BasePermissionAppCompatActivity() {
    lateinit var cpListView: ListView
    lateinit var dataCursor: Cursor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        cpListView = findViewById(R.id.cpListview)
        val tableNameUri: Uri = Uri.parse("content://sms/inbox")
        getReadSMSPermission(object : RequestPermissionAction {
            override fun permissionDenied() {
                // Call Back, when permission is Denied
            }

            override fun permissionGranted() {
                // Call Back, when permission is Granted
                 dataCursor =
                     contentResolver.query(tableNameUri, null, null, null, null)!!
                var fromColNames = arrayOf("body", "address")
                var toTextviewIds = intArrayOf(android.R.id.text1, android.R.id.text2)

                var myAdapter = SimpleCursorAdapter(
                    applicationContext,
                    android.R.layout.simple_list_item_2,
                    dataCursor,
                    fromColNames,
                    toTextviewIds
                )
                cpListView.adapter = myAdapter

            }

        });


    }





}