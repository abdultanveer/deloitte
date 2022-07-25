package com.example.deloitte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.deloitte.database.DbAccessObject
import com.example.deloitte.database.Note

class TodoActivity : AppCompatActivity() {
    lateinit var etTitle:EditText
    lateinit var etSubtitle: EditText
    lateinit var dbAccessObject: DbAccessObject

    lateinit var tvDbResult:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        etTitle = findViewById(R.id.etTitle)
        etSubtitle = findViewById(R.id.etSubtitle)
        tvDbResult = findViewById(R.id.tvDbResult)
        dbAccessObject = DbAccessObject(this)
        dbAccessObject.openDb()
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