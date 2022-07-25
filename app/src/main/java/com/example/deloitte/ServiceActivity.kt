package com.example.deloitte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
    }

    fun serviceHandler(view: View) {
        when(view.id){
            R.id.btnStart ->{
            var serviceIntent = Intent(this,MyService::class.java)
                serviceIntent.putExtra("musicfilename","somemusic.mp3")
                startService(serviceIntent)
            }
            R.id.btnStop ->{
                var serviceIntent = Intent(this,MyService::class.java)
                stopService(serviceIntent)
            }
        }
    }
}