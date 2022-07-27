package com.example.deloitte.contentproviders

import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import com.example.deloitte.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.deloitte.database.FeedReaderContract.FeedEntry;

//https://www.geeksforgeeks.org/content-providers-in-android-with-example/
class ContentProviderActivity : BasePermissionAppCompatActivity() {
    lateinit var cpListView: ListView
    lateinit var dataCursor: Cursor
    lateinit var tvFirestore: TextView
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        tvFirestore = findViewById(R.id.tvFsResult)
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

    fun firestoreHandler(view: View) {
        when(view.id){
            R.id.btnSend -> { sendDataFirestore()}
            R.id.btnFsGet ->{ getDataFirestore()}
        }
    }

    private fun getDataFirestore() {
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    tvFirestore.text = "${document.data}"
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    private fun sendDataFirestore() {
        // Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    companion object {
        var TAG = ContentProviderActivity::class.java.simpleName
    }

    fun handlerContentprovider(view: View) {
        when(view.id){
            R.id.btnPutContentprovider -> {putCprovider()}
            R.id.btnGetContentprovider -> {getCprovider()}
        }

    }

    private fun putCprovider() {
        val tableNameUri: Uri = Uri.parse("content://entry.todo/entry")
        var values = ContentValues()
        values.put(FeedEntry.COLUMN_NAME_TITLE,"deloitte")
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,"android")
        contentResolver.insert(tableNameUri,values)

    }

    private fun getCprovider() {
        val tableNameUri: Uri = Uri.parse("content://entry.todo")
        var cursor = contentResolver.query(tableNameUri,null,null,null,null)
        cursor?.moveToLast()
        var titleIndex = cursor?.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE)
        var title = titleIndex?.let { cursor?.getString(it) }

        var subtitleIndex = cursor?.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE)
        var subtitle = subtitleIndex?.let { cursor?.getString(it) }

        tvFirestore.text =  title + "\n"+ subtitle
    }


}