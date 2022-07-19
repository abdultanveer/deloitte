package com.example.deloitte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import android.widget.TextView

//nullability, compile time inference of data types
class HomeActivity : AppCompatActivity() {
     lateinit var dEmployee : Employee
    lateinit var homeTextView: TextView
    lateinit var etHome:EditText
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        dEmployee = Employee(1,"abdul",123,"hyd")
        dEmployee.name = "ansari"
        homeTextView = findViewById(R.id.tvHome)
        etHome = findViewById(R.id.etHome)
        webView = findViewById(R.id.webview)

        //webView.loadUrl("https://www.yahoo.com");
        val unencodedHtml =
            "<html><body>'%23' is the percent code for ‘#‘ </body></html>";
        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
        webView.loadData(encodedHtml, "text/html", "base64")
        //get the intent which started this activity
        var mIntent = intent //getIntent()
        //get the extras
      /* var mextras =  mIntent.extras
        //get the data from extras
        var name = mextras?.getString(MainActivity.DATA_KEY)
        //set the data into the textview
       // homeTextView.setText(name)
        homeTextView.text = name*/
    }

    fun resultHandler(view: View) {
        //send the result[contact] back to the parent activity[MainActivity]
            //get the data from the edittext
        var contact : String = etHome.text.toString()
        homeTextView.text = contact
            //put the data into an intent
       /* var mIntent  = Intent()
        mIntent.putExtra("ckey",contact)
            //set the result
        setResult(RESULT_OK,mIntent)
            //finish this current activity
        finish()*/

    }
}