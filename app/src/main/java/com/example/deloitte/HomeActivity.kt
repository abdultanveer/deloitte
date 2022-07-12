package com.example.deloitte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//nullability, compile time inference of data types
class HomeActivity : AppCompatActivity() {
     lateinit var dEmployee : Employee
    lateinit var homeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        dEmployee = Employee(1,"abdul",123,"hyd")
        dEmployee.name = "ansari"
        homeTextView = findViewById(R.id.tvHome)
        //get the intent which started this activity
        var mIntent = intent //getIntent()
        //get the extras
       var mextras =  mIntent.extras
        //get the data from extras
        var name = mextras?.getString(MainActivity.DATA_KEY)
        //set the data into the textview
       // homeTextView.setText(name)
        homeTextView.text = name
    }
}